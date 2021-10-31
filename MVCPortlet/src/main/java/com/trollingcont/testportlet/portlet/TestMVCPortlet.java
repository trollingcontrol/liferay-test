package com.trollingcont.testportlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.trollingcont.servicebuilder.service.ElectronicsLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Liferay MVC Portlet",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
class TestMVCPortlet extends MVCPortlet {

        @Reference
        public volatile ElectronicsLocalService _electronicsLocalService;

        @Override
        public void render(RenderRequest renderRequest, RenderResponse renderResponse)
                throws IOException, PortletException {

                renderRequest.setAttribute("electronicsLocalService", getElectronicsLocalService());

                super.render(renderRequest, renderResponse);
        }

        public ElectronicsLocalService getElectronicsLocalService() {
                return _electronicsLocalService;
        }
}