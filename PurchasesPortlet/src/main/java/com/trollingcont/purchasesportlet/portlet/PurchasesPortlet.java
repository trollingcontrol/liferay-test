package com.trollingcont.purchasesportlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.trollingcont.purchasesportlet.constants.PurchasesPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.sound.sampled.Port;

import com.trollingcont.servicebuilder.exception.NoSuchEmployeeException;
import com.trollingcont.servicebuilder.exception.NoSuchProductException;
import com.trollingcont.servicebuilder.exception.NoSuchPurchaseException;
import com.trollingcont.servicebuilder.exception.NoSuchPurchaseTypeException;
import com.trollingcont.servicebuilder.model.Employee;
import com.trollingcont.servicebuilder.model.EmployeeRight;
import com.trollingcont.servicebuilder.model.Product;
import com.trollingcont.servicebuilder.model.Purchase;
import com.trollingcont.servicebuilder.service.*;
import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author omskd
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Purchases",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PurchasesPortletKeys.PURCHASES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PurchasesPortlet extends MVCPortlet {

	public void addPurchase(ActionRequest request, ActionResponse response)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Purchase.class.getName(), request
		);

		boolean isSuccessful = false;

		try {
			long productId = Long.parseUnsignedLong(ParamUtil.getString(request, "productId"));
			long employeeId = Long.parseUnsignedLong(ParamUtil.getString(request, "employeeId"));
			long purchaseTypeId = Long.parseUnsignedLong(ParamUtil.getString(request, "purchaseTypeId"));

			PurchaseTypeLocalServiceUtil.getPurchaseType(purchaseTypeId);

			Product product = ProductLocalServiceUtil.getProduct(productId);

			if (product.getAmount() <= 0 || product.getArchived() || !product.getPresent()) {
				throw new IllegalStateException("productIsMissing");
			}

			EmployeeLocalServiceUtil.getEmployee(employeeId);

			if (!EmployeeRightLocalServiceUtil.hasEmployeeRight(employeeId, product.getProductTypeId())) {
				throw new IllegalStateException("accessDenied");
			}

			product.setAmount(product.getAmount() - 1);

			ProductLocalServiceUtil.updateProduct(product);

			PurchaseLocalServiceUtil.addPurchase(
					productId,
					employeeId,
					purchaseTypeId,
					new Date(),
					serviceContext
			);

			SessionMessages.add(request, "purchaseAdded");

			isSuccessful = true;
		}
		catch (IllegalStateException ise) {
			SessionErrors.add(request, ise.getMessage());
		}
		catch (NumberFormatException nfe) {
			SessionErrors.add(request, "invalidNumbers");
		}
		catch (NoSuchProductException nspe) {
			SessionErrors.add(request, "purchasedProductNotFound");
		}
		catch (NoSuchEmployeeException nsee) {
			SessionErrors.add(request, "employeeNotFound");
		}
		catch (NoSuchPurchaseTypeException nspte) {
			SessionErrors.add(request, "purchaseTypeNotFound");
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "errorAddingPurchase");
		}

		PortalUtil.copyRequestParameters(request, response);

		response.setRenderParameter(
				"mvcPath",
				isSuccessful ? "/view.jsp" : "/add_purchase.jsp"
		);
	}

	public void deletePurchase(ActionRequest request, ActionResponse response)
			throws PortalException {

		try {
			long id = Long.parseUnsignedLong(ParamUtil.getString(request, "purchaseIdToBeDeleted"));
			long productId = Long.parseUnsignedLong(ParamUtil.getString(request, "productId"));

			PurchaseLocalServiceUtil.deletePurchase(id);

			Product product = ProductLocalServiceUtil.getProduct(productId);
			product.setAmount(product.getAmount() + 1);
			ProductLocalServiceUtil.updateProduct(product);

			SessionMessages.add(request, "purchaseDeleted");
		}
		catch (NumberFormatException nfe) {
			SessionErrors.add(request, "invalidNumbers");
		}
		catch (NoSuchPurchaseException nspe) {
			SessionErrors.add(request, "purchaseNotFound");
		}
		catch (NoSuchProductException nspe) {
			SessionErrors.add(request, "returnedProductNotFound");
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "errorDeletingPurchase");
		}
	}
}