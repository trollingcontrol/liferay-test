package com.trollingcont.employeesportlet.portlet;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;
import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.trollingcont.employeesportlet.constants.EmployeesPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import com.trollingcont.servicebuilder.exception.EmployeeException;
import com.trollingcont.servicebuilder.exception.NoSuchEmployeeException;
import com.trollingcont.servicebuilder.exception.NoSuchPostException;
import com.trollingcont.servicebuilder.model.Employee;
import com.trollingcont.servicebuilder.model.Product;
import com.trollingcont.servicebuilder.service.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		"javax.portlet.display-name=Employees",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeesPortletKeys.EMPLOYEES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EmployeesPortlet extends MVCPortlet {

	Log log = LogFactoryUtil.getLog(EmployeesPortlet.class.getName());

	SimpleDateFormat inputDateFormat = new SimpleDateFormat("MM/dd/yyyy");

	public void addEmployee(ActionRequest request, ActionResponse response)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Employee.class.getName(), request
		);

		boolean isSuccessful = false;

		String firstName = ParamUtil.getString(request, "firstName");
		String lastName = ParamUtil.getString(request, "lastName");
		String middleName = ParamUtil.getString(request, "middleName");
		String postId = ParamUtil.getString(request, "postId");
		boolean sexGroup = ParamUtil.getBoolean(request, "sexGroup");

		try {
			long postIdLong = Long.parseUnsignedLong(postId);
			Date birthDate  = inputDateFormat.parse(ParamUtil.getString(request, "birthDate"));

			_postLocalService.getPost(postIdLong);

			_employeeLocalService.addEmployee(
					firstName,
					lastName,
					middleName,
					birthDate,
					postIdLong,
					sexGroup,
					serviceContext
			);

			SessionMessages.add(request, "employeeAdded");

			isSuccessful = true;

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
					"mvcPath", "/view.jsp"
			);
		}
		catch (ParseException pe) {
			SessionErrors.add(request, "invalidDateFormat");
		}
		catch (NumberFormatException nfe) {
			SessionErrors.add(request, "invalidNumbers");
		}
		catch (EmployeeException ee) {
			SessionErrors.add(request, "invalidNames");
		}
		catch (NoSuchPostException nspe) {
			SessionErrors.add(request, "postNotFound");
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "errorAddingEmployee");
		}

		if (!isSuccessful) {
			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
					"mvcPath", "/add_employee.jsp"
			);
		}
	}

	public void editEmployee(ActionRequest request, ActionResponse response)
			throws PortalException  {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Employee.class.getName(), request
		);

		boolean isSuccessful = false;

		String strId = ParamUtil.getString(request, "id");
		String firstName = ParamUtil.getString(request, "newFirstName");
		String lastName = ParamUtil.getString(request, "newLastName");
		String middleName = ParamUtil.getString(request, "newMiddleName");
		String postId = ParamUtil.getString(request, "newPostId");
		boolean sexGroup = ParamUtil.getBoolean(request, "newSexGroup");

		try {
			long idLong = Long.parseUnsignedLong(strId);
			long postIdLong = Long.parseUnsignedLong(postId);
			Date birthDate  = inputDateFormat.parse(ParamUtil.getString(request, "newBirthDate"));

			_postLocalService.getPost(postIdLong);

			Employee employee = _employeeLocalService.getEmployee(idLong);

			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setMiddleName(middleName);
			employee.setSex(sexGroup);
			employee.setBirthDate(birthDate);

			_employeeLocalService.updateEmployee(employee, serviceContext);

			SessionMessages.add(request, "employeeUpdated");

			isSuccessful = true;

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
					"mvcPath", "/view.jsp"
			);
		}
		catch (ParseException pe) {
			SessionErrors.add(request, "invalidDateFormat");
		}
		catch (NumberFormatException nfe) {
			SessionErrors.add(request, "invalidNumbers");
		}
		catch (EmployeeException ee) {
			SessionErrors.add(request, "invalidNames");
		}
		catch (NoSuchEmployeeException nsee) {
			SessionErrors.add(request, "employeeNotFound");
		}
		catch (NoSuchPostException nspe) {
			SessionErrors.add(request, "postNotFound");
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "errorUpdatingEmployee");
		}

		if (!isSuccessful) {
			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
					"mvcPath", "/edit_employee.jsp"
			);
		}
	}

	public void deleteEmployee(ActionRequest request, ActionResponse response)
			throws PortalException  {

		String strId = ParamUtil.getString(request, "employeeIdToBeDeleted");

		try {
			_employeeLocalService.deleteEmployee(Long.parseUnsignedLong(strId));

			SessionMessages.add(request, "employeeDeleted");
		}
		catch (NumberFormatException nfe) {
			SessionErrors.add(request, "invalidNumbers");
		}
		catch (NoSuchEmployeeException nsee) {
			SessionErrors.add(request, "employeeNotFound");
		}
		catch (PortalException pe) {
			SessionErrors.add(request, "errorDeletingEmployee");
		}

	}

	@Reference(unbind = "-")
	protected void setEmployeeLocalService(EmployeeLocalService employeeLocalService) {
		_employeeLocalService = employeeLocalService;
	}

	@Reference(unbind = "-")
	protected void setPostLocalService(PostLocalService postLocalService) {
		_postLocalService = postLocalService;
	}

	private EmployeeLocalService _employeeLocalService;
	private PostLocalService _postLocalService;
}