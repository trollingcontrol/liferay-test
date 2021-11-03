package com.trollingcont.producttypes.portlet;

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
import com.trollingcont.producttypes.constants.ProductTypesPortletKeys;
import com.trollingcont.servicebuilder.exception.NoSuchProductTypeException;
import com.trollingcont.servicebuilder.exception.ProductTypeException;
import com.trollingcont.servicebuilder.model.ProductType;
import com.trollingcont.servicebuilder.service.ProductTypeLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;

/**
 * @author omskd
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Full",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ProductTypesPortletKeys.FULL,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProductTypesPortlet extends MVCPortlet {
	Log log = LogFactoryUtil.getLog(ProductTypesPortlet.class.getName());

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		String productTypeName = (String) renderRequest.getAttribute("productTypeName");

		System.out.printf("PRODUCT TYPE NAME = %s\n", productTypeName);

		super.render(renderRequest, renderResponse);
	}

	public void addProductType(ActionRequest request, ActionResponse response)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ProductType.class.getName(), request
		);

		String name = ParamUtil.getString(request, "productTypeName");

		try {
			_productTypeLocalService.addProductType(name, serviceContext);
			SessionMessages.add(request, "productTypeAdded");

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
					"mvcPath", "/view.jsp"
			);
		}
		catch (ProductTypeException etne) {

			switch (etne.errorCode()) {
				case NAME_EMPTY:
					SessionErrors.add(request, "missingProductTypeName");
					break;
				case NAME_TOO_LONG:
					SessionErrors.add(request, "productTypeNameTooLong");
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
					"mvcPath", "/add_product_type.jsp"
			);

		}
		catch (PortalException pe) {
			SessionErrors.add(request, "failedToAddProductType");

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
					"mvcPath", "/add_product_type.jsp"
			);
		}
	}

	public void editProductType(ActionRequest request, ActionResponse response)
			throws PortalException {

		String strId = ParamUtil.getString(request, "productTypeId");
		String name = ParamUtil.getString(request, "productTypeName");
		boolean isSuccessful = false;

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ProductType.class.getName(), request
		);

		try {
			ProductType productType = _productTypeLocalService.getProductType(Long.parseUnsignedLong(strId));

			if (!productType.getName().equals(name)) {
				productType.setName(name);
				_productTypeLocalService.updateProductType(productType, serviceContext);
				SessionMessages.add(request, "productTypeUpdated");
			}
			else {
				SessionMessages.add(request, "productNameNotChanged");
			}

			isSuccessful = true;
		}
		catch (NumberFormatException nfe) {
			SessionErrors.add(request, "invalidProductTypeId");
		}
		catch (ProductTypeException pte) {
			switch (pte.errorCode()) {
				case NAME_EMPTY:
					SessionErrors.add(request, "missingProductTypeName");
					break;
				case NAME_TOO_LONG:
					SessionErrors.add(request, "productTypeNameTooLong");
			}
		}
		catch (NoSuchProductTypeException nspte) {
			SessionErrors.add(request, "productTypeNotFound");
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "errorDeletingProductType");
		}

		PortalUtil.copyRequestParameters(request, response);

		if (isSuccessful) {
			response.setRenderParameter("mvcPath", "/view.jsp");
		}
		else {
			response.setRenderParameter("mvcPath", "/edit_product_type.jsp");
		}
	}

	public void deleteProductType(ActionRequest request, ActionResponse response)
			throws PortalException {

		long id = ParamUtil.getLong(request, "productTypeId", -1);
		boolean isSuccessful = false;

		if (id > 0) {
			try {
				_productTypeLocalService.deleteProductType(id);
				SessionMessages.add(request, "productTypeDeleted");
				isSuccessful = true;
			}
			catch (NoSuchProductTypeException nspte) {
				SessionErrors.add(request, "productTypeNotFound");
			}
			catch (PortalException pe) {
				SessionErrors.add(request, "errorDeletingProductType");
			}
		}
		else {
			SessionErrors.add(request, "invalidProductTypeId");
		}

		PortalUtil.copyRequestParameters(request, response);

		if (isSuccessful) {
			response.setRenderParameter("mvcPath", "/view.jsp");
		}
		else {
			response.setRenderParameter("mvcPath", "/edit_product_type.jsp");
		}
	}

	public void findProductType(ActionRequest request, ActionResponse response)
			throws PortalException {

		String strId = ParamUtil.getString(request, "productTypeId");
		boolean isSuccessful = false;

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ProductType.class.getName(), request
		);

		try {
			ProductType productType = _productTypeLocalService.getProductType(Long.parseUnsignedLong(strId));
			request.setAttribute("productTypeName", productType.getName());
		}
		catch (NumberFormatException nfe) {
			SessionErrors.add(request, "invalidProductTypeId");
		}
		catch (NoSuchProductTypeException nspte) {
			SessionErrors.add(request, "productTypeNotFound");
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "errorGettingProductType");
		}

		PortalUtil.copyRequestParameters(request, response);

		response.setRenderParameter("mvcPath", "/edit_product_type.jsp");
	}

	@Reference(unbind = "-")
	protected void setElectronicsTypeLocalService(ProductTypeLocalService electronicsTypeLocalService) {
		_productTypeLocalService = electronicsTypeLocalService;
	}

	private ProductTypeLocalService _productTypeLocalService;
}