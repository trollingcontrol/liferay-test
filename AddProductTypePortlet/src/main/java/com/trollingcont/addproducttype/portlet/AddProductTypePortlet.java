package com.trollingcont.addproducttype.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.trollingcont.addproducttype.constants.AddProductTypePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import com.trollingcont.servicebuilder.exception.ProductTypeException;
import com.trollingcont.servicebuilder.model.ProductType;
import com.trollingcont.servicebuilder.service.ProductTypeLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author user
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AddProductType",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AddProductTypePortletKeys.ADDPRODUCTTYPE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AddProductTypePortlet extends MVCPortlet {

	public void addProductType(ActionRequest request, ActionResponse response)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ProductType.class.getName(), request
		);

		String typeName = ParamUtil.getString(request, "productTypeName");



		try {
			_productTypeLocalService.addProductType(typeName, serviceContext);
			SessionMessages.add(request, "productTypeAdded");
		}
		catch (ProductTypeException etne) {

			switch (etne.errorCode()) {
				case NAME_EMPTY:
					SessionErrors.add(request, "missingProductTypeName");
					break;
				case NAME_TOO_LONG:
					SessionErrors.add(request, "productTypeNameTooLong");
			}
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "failedToAddProductType");
		}

		PortalUtil.copyRequestParameters(request, response);

		response.setRenderParameter(
				"mvcPath", "/view.jsp"
		);
	}

	@Reference(unbind = "-")
	protected void setElectronicsTypeLocalService(ProductTypeLocalService electronicsTypeLocalService) {
		_productTypeLocalService = electronicsTypeLocalService;
	}

	private ProductTypeLocalService _productTypeLocalService;
}