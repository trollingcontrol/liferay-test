package com.trollingcont.fullportlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.sun.org.slf4j.internal.LoggerFactory;
import com.trollingcont.fullportlet.constants.FullPortletKeys;
import com.trollingcont.servicebuilder.model.Electronics;
import com.trollingcont.servicebuilder.service.ElectronicsLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
		"javax.portlet.init-param.view-template=/guestportlet/view.jsp",
		"javax.portlet.name=" + FullPortletKeys.FULL,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FullPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		super.render(renderRequest, renderResponse);
	}

	public void addProduct(ActionRequest request, ActionResponse response)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Electronics.class.getName(), request
		);

		String name = ParamUtil.getString(request, "name");
		int typeId = ParamUtil.get(request, "typeId", -1);
		int cost = ParamUtil.get(request, "cost", -1);
		int amount = ParamUtil.get(request, "amount", -1);

		//TODO Replace by normal logging
		System.out.printf("ADDING PRODUCT (%s %d %d %d)\n", name, typeId, cost, amount);

		if (typeId > 0 && cost > 0 && amount > 0) {
			try {
				Electronics newProduct = _electronicsLocalService.addElectronics(
						name, typeId, cost, amount, true, true, "Sample desc", serviceContext
				);

				//TODO Replace by normal logging
				System.out.printf("ADDING PRODUCT: Success (id=%d)\n", newProduct.getProductId());

				SessionMessages.add(request, "productAdded");

				response.setRenderParameter(
						"productId", Long.toString(newProduct.getProductId())
				);
			}
			catch (Exception e) {
				e.printStackTrace();

				SessionErrors.add(request, e.getClass().getName());

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter(
						"mvcPath", "/guestportlet/create_product.jsp"
				);
			}
		}
		else {
			SessionErrors.add(request, "invalidInput");

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
					"mvcPath", "/guestportlet/create_product.jsp"
			);
		}
	}

	@Reference(unbind = "-")
	protected void setElectronicsLocalService(ElectronicsLocalService electronicsLocalService) {
		_electronicsLocalService = electronicsLocalService;
	}

	private ElectronicsLocalService _electronicsLocalService;
}