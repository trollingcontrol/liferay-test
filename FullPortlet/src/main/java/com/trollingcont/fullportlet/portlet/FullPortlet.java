package com.trollingcont.fullportlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.trollingcont.fullportlet.constants.FullPortletKeys;
import com.trollingcont.servicebuilder.service.ElectronicsLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * @author omskd
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Full",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FullPortletKeys.FULL,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FullPortlet extends MVCPortlet {

	@Reference
	private volatile ElectronicsLocalService _electronicsLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		renderRequest.setAttribute("electronicsLocalService", getElectronicsLocalService());

		System.out.println("LA DI DA");

		super.render(renderRequest, renderResponse);
	}


	public ElectronicsLocalService getElectronicsLocalService() {
		return _electronicsLocalService;
	}
}