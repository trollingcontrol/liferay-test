package com.trollingcont.postsportlet.portlet;

import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.trollingcont.postsportlet.constants.PostsPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import com.trollingcont.servicebuilder.exception.PostException;
import com.trollingcont.servicebuilder.model.Post;
import com.trollingcont.servicebuilder.model.Product;
import com.trollingcont.servicebuilder.service.PostLocalService;
import com.trollingcont.servicebuilder.service.PostLocalServiceUtil;
import com.trollingcont.servicebuilder.service.ProductLocalService;
import com.trollingcont.servicebuilder.service.ProductTypeLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author omskd
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Posts",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PostsPortletKeys.POSTS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PostsPortlet extends MVCPortlet {

	public void addPost(ActionRequest request, ActionResponse response) throws PortalException {

		String name = ParamUtil.getString(request, "name");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Post.class.getName(), request
		);

		boolean isSuccessful = false;

		try {
			_postLocalService.addPost(name, serviceContext);

			SessionMessages.add(request, "productTypeAdded");

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
					"mvcPath", "/view.jsp"
			);

			isSuccessful = true;
		}
		catch (PostException pe) {
			switch (pe.errorCode()) {
				case NAME_TOO_LONG:
					SessionErrors.add(request, "nameTooLong");
					break;
				case NAME_EMPTY:
					SessionErrors.add(request, "nameEmpty");
			}
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "errorAddingPost");
		}

		if (!isSuccessful) {
			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
					"mvcPath", "/add_post.jsp"
			);
		}
	}

	public void editPost(ActionRequest request, ActionResponse response) {

	}

	public void deletePost(ActionRequest request, ActionResponse response) {

	}

	@Reference(unbind = "-")
	protected void setPostLocalService(PostLocalService postLocalService) {
		_postLocalService = postLocalService;
	}

	private PostLocalService _postLocalService;
}