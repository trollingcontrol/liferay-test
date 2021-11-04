package com.trollingcont.productsportlet.portlet;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;
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
import com.trollingcont.servicebuilder.exception.NoSuchProductTypeException;
import com.trollingcont.servicebuilder.exception.ProductException;
import com.trollingcont.servicebuilder.model.Product;
import com.trollingcont.servicebuilder.model.ProductType;
import com.trollingcont.servicebuilder.service.ProductLocalService;
import com.trollingcont.servicebuilder.service.ProductTypeLocalService;
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

	Log log = LogFactoryUtil.getLog(ProductsPortlet.class.getName());

	public void addProduct(ActionRequest request, ActionResponse response)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Product.class.getName(), request
		);

		String name = ParamUtil.getString(request, "productName");
		String productTypeId = ParamUtil.getString(request, "productTypeId");
		String amount = ParamUtil.getString(request, "amount");
		String cost = ParamUtil.getString(request, "cost");
		boolean present = ParamUtil.getBoolean(request, "present");
		boolean archived = ParamUtil.getBoolean(request, "archived");
		String description = ParamUtil.getString(request, "description");

		try {
			long productTypeIdLong = Long.parseUnsignedLong(productTypeId);

			_productTypeLocalService.getProductType(productTypeIdLong);

			_productLocalService.addProduct(
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
	}

	public void editProduct(ActionRequest request, ActionResponse response)
			throws PortalException {

	}

	public void deleteProduct(ActionRequest request, ActionResponse response)
			throws PortalException {

	}

	@Reference(unbind = "-")
	protected void setProductTypeLocalService(ProductTypeLocalService electronicsTypeLocalService) {
		_productTypeLocalService = electronicsTypeLocalService;
	}

	@Reference(unbind = "-")
	protected void setProductLocalService(ProductLocalService productLocalService) {
		_productLocalService = productLocalService;
	}

	private ProductTypeLocalService _productTypeLocalService;
	private ProductLocalService _productLocalService;
}