/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.trollingcont.servicebuilder.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.trollingcont.servicebuilder.exception.EmployeeException;
import com.trollingcont.servicebuilder.model.Employee;
import com.trollingcont.servicebuilder.service.base.EmployeeLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * The implementation of the employee local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.trollingcont.servicebuilder.service.EmployeeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.trollingcont.servicebuilder.model.Employee",
	service = AopService.class
)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.trollingcont.servicebuilder.service.EmployeeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.trollingcont.servicebuilder.service.EmployeeLocalServiceUtil</code>.
	 */

	private final int MAX_FIRST_NAME_LENGTH = 100;
	private final int MAX_LAST_NAME_LENGTH = 100;
	private final int MAX_MIDDLE_NAME_LENGTH = 100;

	public Employee addEmployee(
			String firstName,
			String lastName,
			String middleName,
			Date birthDate,
			long postId,
			boolean sex,
			ServiceContext serviceContext
	) throws PortalException {

		validate(firstName, lastName, middleName);

		long entryId = counterLocalService.increment();

		Employee employee = employeePersistence.create(entryId);

		employee.setUuid(serviceContext.getUuid());
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setMiddleName(middleName);
		employee.setBirthDate(birthDate);
		employee.setPostId(postId);
		employee.setSex(sex);
		employee.setExpandoBridgeAttributes(serviceContext);

		employeePersistence.update(employee);

		return employee;
	}

	public Employee updateEmployee(
			Employee employee,
			ServiceContext serviceContext
	) throws PortalException {

		validate(employee.getFirstName(), employee.getLastName(), employee.getMiddleName());

		employee.setExpandoBridgeAttributes(serviceContext);

		employeePersistence.update(employee);

		return employee;
	}

	protected void validate(
			String firstName,
			String lastName,
			String middleName
	) throws EmployeeException {

		if (firstName == null || firstName.isBlank()) {
			throw new EmployeeException(EmployeeException.ErrorCode.FIRST_NAME_EMPTY);
		}

		if (firstName.length() > MAX_FIRST_NAME_LENGTH) {
			throw new EmployeeException(EmployeeException.ErrorCode.FIRST_NAME_TOO_LONG);
		}

		if (lastName == null || lastName.isBlank()) {
			throw new EmployeeException(EmployeeException.ErrorCode.LAST_NAME_EMPTY);
		}

		if (lastName.length() > MAX_LAST_NAME_LENGTH) {
			throw new EmployeeException(EmployeeException.ErrorCode.LAST_NAME_TOO_LONG);
		}

		if (middleName == null || middleName.isBlank()) {
			throw new EmployeeException(EmployeeException.ErrorCode.MIDDLE_NAME_EMPTY);
		}

		if (middleName.length() > MAX_MIDDLE_NAME_LENGTH) {
			throw new EmployeeException(EmployeeException.ErrorCode.MIDDLE_NAME_TOO_LONG);
		}
	}
}