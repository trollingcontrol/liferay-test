package com.trollingcont.purchasetypesportlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.trollingcont.purchasetypesportlet.constants.PurchaseTypesPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import com.trollingcont.servicebuilder.exception.NoSuchPurchaseTypeException;
import com.trollingcont.servicebuilder.exception.PurchaseTypeException;
import com.trollingcont.servicebuilder.model.ProductType;
import com.trollingcont.servicebuilder.model.PurchaseType;
import com.trollingcont.servicebuilder.service.PurchaseTypeLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

/**
 * @author user
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PurchaseTypes",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PurchaseTypesPortletKeys.PURCHASETYPES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PurchaseTypesPortlet extends MVCPortlet {

	public void addPurchaseType(ActionRequest request, ActionResponse response) throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				PurchaseType.class.getName(), request
		);

		String name = ParamUtil.getString(request, "name");

		boolean isSuccessful = false;

		try {
			PurchaseTypeLocalServiceUtil.addPurchaseType(name, serviceContext);
			SessionMessages.add(request, "purchaseTypeAdded");

			isSuccessful = true;
		}
		catch (PurchaseTypeException pte) {
			switch (pte.errorCode()) {
				case NAME_EMPTY:
					SessionErrors.add(request, "nameEmpty");
					break;
				case NAME_TOO_LONG:
					SessionErrors.add(request, "nameTooLong");
			}
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "errorAddingPurchaseType");
		}

		PortalUtil.copyRequestParameters(request, response);

		response.setRenderParameter(
				"mvcPath",
				isSuccessful ? "/view.jsp" : "/add_purchase_type.jsp"
		);
	}

	public void editPurchaseType(ActionRequest request, ActionResponse response) throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				PurchaseType.class.getName(), request
		);

		boolean isSuccessful = false;

		long id = ParamUtil.getLong(request, "id");
		String newName = ParamUtil.getString(request, "newName");

		try {
			PurchaseType purchaseType = PurchaseTypeLocalServiceUtil.getPurchaseType(id);

			purchaseType.setName(newName);

			PurchaseTypeLocalServiceUtil.updatePurchaseType(purchaseType, serviceContext);

			SessionMessages.add(request, "purchaseTypeUpdated");

			isSuccessful = true;
		}
		catch (NoSuchPurchaseTypeException nspte) {
			SessionErrors.add(request, "purchaseTypeNotFound");
		}
		catch (PurchaseTypeException pte) {
			switch (pte.errorCode()) {
				case NAME_EMPTY:
					SessionErrors.add(request, "nameEmpty");
					break;
				case NAME_TOO_LONG:
					SessionErrors.add(request, "nameTooLong");
			}
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "errorUpdatingPurchaseType");
		}

		PortalUtil.copyRequestParameters(request, response);

		response.setRenderParameter(
				"mvcPath",
				isSuccessful ? "/view.jsp" : "/edit_purchase_type.jsp"
		);
	}

	public void deletePurchaseType(ActionRequest request, ActionResponse response) {

		long id = ParamUtil.getLong(request, "purchaseTypeIdToBeDeleted");

		try {
			PurchaseTypeLocalServiceUtil.deletePurchaseType(id);

			SessionMessages.add(request, "purchaseTypeDeleted");
		}
		catch (NoSuchPurchaseTypeException nspte) {
			SessionErrors.add(request, "purchaseTypeNotFound");
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "errorDeletingPurchaseType");
		}
	}
}