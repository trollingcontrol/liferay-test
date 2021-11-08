package com.trollingcont.purchasetypesportlet.portlet;

import com.trollingcont.purchasetypesportlet.constants.PurchaseTypesPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

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

	public void addPurchaseType(ActionRequest request, ActionResponse response) {

	}

	public void editPurchaseType(ActionRequest request, ActionResponse response) {

	}

	public void deletePurchaseType(ActionRequest request, ActionResponse response) {

	}
}