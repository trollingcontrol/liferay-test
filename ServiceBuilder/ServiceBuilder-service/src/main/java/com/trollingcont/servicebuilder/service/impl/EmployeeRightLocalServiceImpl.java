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
import com.trollingcont.servicebuilder.model.EmployeeRight;
import com.trollingcont.servicebuilder.service.base.EmployeeRightLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the employee right local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.trollingcont.servicebuilder.service.EmployeeRightLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeRightLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.trollingcont.servicebuilder.model.EmployeeRight",
	service = AopService.class
)
public class EmployeeRightLocalServiceImpl
	extends EmployeeRightLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.trollingcont.servicebuilder.service.EmployeeRightLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.trollingcont.servicebuilder.service.EmployeeRightLocalServiceUtil</code>.
	 */

	public EmployeeRight addEmployeeRight(
			long employeeId,
			long productTypeId,
			ServiceContext serviceContext
	) {

		long entryId = counterLocalService.increment();

		EmployeeRight employeeRight = employeeRightPersistence.create(entryId);

		employeeRight.setEmployeeId(employeeId);
		employeeRight.setProductTypeId(productTypeId);
		employeeRight.setExpandoBridgeAttributes(serviceContext);

		employeeRightPersistence.update(employeeRight);

		return employeeRight;
	}

	public List<EmployeeRight> getEmployeeRightsList(
			long employeeId
	) {

		return employeeRightPersistence.findByEmployeeRightsList(employeeId);

	}

	public boolean hasEmployeeRight(
			long employeeId,
			long productTypeId
	) {

		return employeeRightPersistence.countByEmployeeSingleRight(employeeId, productTypeId) != 0;
	}
}