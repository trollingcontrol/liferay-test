package com.trollingcont.productsportlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.trollingcont.productsportlet.constants.ProductsPortletKeys;
import com.trollingcont.servicebuilder.exception.NoSuchProductException;
import com.trollingcont.servicebuilder.exception.NoSuchProductTypeException;
import com.trollingcont.servicebuilder.exception.ProductException;
import com.trollingcont.servicebuilder.model.Product;
import com.trollingcont.servicebuilder.service.ProductLocalService;
import com.trollingcont.servicebuilder.service.ProductLocalServiceUtil;
import com.trollingcont.servicebuilder.service.ProductTypeLocalService;
import com.trollingcont.servicebuilder.service.ProductTypeLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

/**
 * @author omskd
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Products",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ProductsPortletKeys.PRODUCTS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProductsPortlet extends MVCPortlet {

	public void addProduct(ActionRequest request, ActionResponse response)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Product.class.getName(), request
		);

		String name = ParamUtil.getString(request, "name");
		String productTypeId = ParamUtil.getString(request, "typeId");
		String amount = ParamUtil.getString(request, "amount");
		String cost = ParamUtil.getString(request, "cost");
		boolean present = ParamUtil.getBoolean(request, "present");
		boolean archived = ParamUtil.getBoolean(request, "archived");
		String description = ParamUtil.getString(request, "description");

		boolean isSuccessful = false;

		try {
			long productTypeIdLong = Long.parseUnsignedLong(productTypeId);

			ProductTypeLocalServiceUtil.getProductType(productTypeIdLong);

			ProductLocalServiceUtil.addProduct(
					name,
					productTypeIdLong,
					Long.parseUnsignedLong(cost),
					Long.parseUnsignedLong(amount),
					present,
					archived,
					description,
					serviceContext
			);

			SessionMessages.add(request, "productAdded");

			isSuccessful = true;

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
					"mvcPath", "/view.jsp"
			);
		}
		catch (NumberFormatException nfe) {
			SessionErrors.add(request, "invalidNumbers");
		}
		catch (ProductException pe) {
			switch (pe.errorCode()) {
				case NAME_EMPTY:
					SessionErrors.add(request, "nameEmpty");
					break;
				case INVALID_COST:
					SessionErrors.add(request, "invalidCost");
					break;
				case NAME_TOO_LONG:
					SessionErrors.add(request, "nameTooLong");
					break;
				case INVALID_AMOUNT:
					SessionErrors.add(request, "invalidAmount");
					break;
				case DESCRIPTION_EMPTY:
					SessionErrors.add(request, "descriptionEmpty");
					break;
				case DESCRIPTION_TOO_LONG:
					SessionErrors.add(request, "descriptionTooLong");
			}
		}
		catch (NoSuchProductTypeException nspte) {
			SessionErrors.add(request, "productTypeIdNotFound");
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "errorAddingProduct");
		}

		if (!isSuccessful) {
			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
					"mvcPath", "/add_product.jsp"
			);
		}
	}

	public void editProduct(ActionRequest request, ActionResponse response)
			throws PortalException {

		String id = ParamUtil.getString(request, "id");
		String name = ParamUtil.getString(request, "newName");
		String typeId = ParamUtil.getString(request, "newTypeId");
		String cost = ParamUtil.getString(request, "newCost");
		String amount = ParamUtil.getString(request, "newAmount");
		boolean present = ParamUtil.getBoolean(request, "newPresent");
		boolean archived = ParamUtil.getBoolean(request, "newArchived");
		String description = ParamUtil.getString(request, "newDescription");

		boolean isSuccessful = false;

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Product.class.getName(), request
		);

		try {

			long idLong = Long.parseUnsignedLong(id);
			long typeIdLong = Long.parseUnsignedLong(typeId);
			long costLong = (long)(Double.parseDouble(cost) * 100);
			long amountLong = Long.parseUnsignedLong(amount);

			Product product = ProductLocalServiceUtil.getProduct(idLong);
			ProductTypeLocalServiceUtil.getProductType(typeIdLong);

			product.setName(name);
			product.setProductTypeId(typeIdLong);
			product.setCost(costLong);
			product.setAmount(amountLong);
			product.setPresent(present);
			product.setArchived(archived);
			product.setDescription(description);

			ProductLocalServiceUtil.updateProduct(product, serviceContext);

			SessionMessages.add(request, "productUpdated");

			isSuccessful = true;

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
					"mvcPath", "/view.jsp"
			);
		}
		catch (NumberFormatException nfe) {
			SessionErrors.add(request, "invalidNumbers");
		}
		catch (ProductException pe) {
			switch (pe.errorCode()) {
				case NAME_EMPTY:
					SessionErrors.add(request, "nameEmpty");
					break;
				case INVALID_COST:
					SessionErrors.add(request, "invalidCost");
					break;
				case NAME_TOO_LONG:
					SessionErrors.add(request, "nameTooLong");
					break;
				case INVALID_AMOUNT:
					SessionErrors.add(request, "invalidAmount");
					break;
				case DESCRIPTION_EMPTY:
					SessionErrors.add(request, "descriptionEmpty");
					break;
				case DESCRIPTION_TOO_LONG:
					SessionErrors.add(request, "descriptionTooLong");
			}
		}
		catch (NoSuchProductTypeException nspte) {
			SessionErrors.add(request, "productTypeIdNotFound");
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "errorAddingProduct");
		}

		if (!isSuccessful) {
			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
					"mvcPath", "/edit_product.jsp"
			);
		}
	}

	public void deleteProduct(ActionRequest request, ActionResponse response) {

		String strId = ParamUtil.getString(request, "productIdToBeDeleted");

		try {
			ProductLocalServiceUtil.deleteProduct(Long.parseUnsignedLong(strId));

			SessionMessages.add(request, "productDeleted");
		}
		catch (NumberFormatException nfe) {
			SessionErrors.add(request, "invalidProductId");
		}
		catch (NoSuchProductException nspe) {
			SessionErrors.add(request, "productIdNotFound");
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "errorDeletingProduct");
		}
	}
}