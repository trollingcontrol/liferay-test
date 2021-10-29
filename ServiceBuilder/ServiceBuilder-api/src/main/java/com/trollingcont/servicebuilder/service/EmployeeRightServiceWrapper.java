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

package com.trollingcont.servicebuilder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeRightService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeRightService
 * @generated
 */
public class EmployeeRightServiceWrapper
	implements EmployeeRightService, ServiceWrapper<EmployeeRightService> {

	public EmployeeRightServiceWrapper(
		EmployeeRightService employeeRightService) {

		_employeeRightService = employeeRightService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeRightService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeRightService getWrappedService() {
		return _employeeRightService;
	}

	@Override
	public void setWrappedService(EmployeeRightService employeeRightService) {
		_employeeRightService = employeeRightService;
	}

	private EmployeeRightService _employeeRightService;

}