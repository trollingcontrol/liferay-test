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

import com.trollingcont.servicebuilder.exception.NoSuchPostException;
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

			SessionMessages.add(request, "postAdded");

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

	public void editPost(ActionRequest request, ActionResponse response) throws PortalException {

		String id = ParamUtil.getString(request, "id");
		String name = ParamUtil.getString(request, "newName");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Post.class.getName(), request
		);

		boolean isSuccessful = false;

		try {
			Post post = _postLocalService.getPost(Long.parseUnsignedLong(id));

			post.setName(name);

			_postLocalService.updatePost(post, serviceContext);

			SessionMessages.add(request, "postUpdated");

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
					"mvcPath", "/view.jsp"
			);

			isSuccessful = true;
		}
		catch (NumberFormatException nfe) {
			SessionErrors.add(request, "invalidNumbers");
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
		catch (NoSuchPostException nspe) {
			SessionErrors.add(request, "postNotFound");
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "errorUpdatingPost");
		}

		if (!isSuccessful) {
			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
					"mvcPath", "/edit_post.jsp"
			);
		}

	}

	public void deletePost(ActionRequest request, ActionResponse response) {

		String postId = ParamUtil.getString(request, "postIdToBeDeleted");

		try {
			_postLocalService.deletePost(Long.parseUnsignedLong(postId));

			SessionMessages.add(request, "postDeleted");
		}
		catch (NumberFormatException nfe) {
			SessionErrors.add(request, "invalidPostId");
		}
		catch (NoSuchPostException nspe) {
			SessionErrors.add(request, "postIdNotFound");
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "errorDeletingPost");
		}
	}

	@Reference(unbind = "-")
	protected void setPostLocalService(PostLocalService postLocalService) {
		_postLocalService = postLocalService;
	}

	private PostLocalService _postLocalService;
}