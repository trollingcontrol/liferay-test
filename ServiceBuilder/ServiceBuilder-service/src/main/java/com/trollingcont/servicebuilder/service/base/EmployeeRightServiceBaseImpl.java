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

package com.trollingcont.servicebuilder.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import com.trollingcont.servicebuilder.model.EmployeeRight;
import com.trollingcont.servicebuilder.service.EmployeeRightService;
import com.trollingcont.servicebuilder.service.EmployeeRightServiceUtil;
import com.trollingcont.servicebuilder.service.persistence.ElectronicsPersistence;
import com.trollingcont.servicebuilder.service.persistence.ElectronicsTypePersistence;
import com.trollingcont.servicebuilder.service.persistence.EmployeePersistence;
import com.trollingcont.servicebuilder.service.persistence.EmployeeRightPersistence;
import com.trollingcont.servicebuilder.service.persistence.PostPersistence;
import com.trollingcont.servicebuilder.service.persistence.PurchasePersistence;
import com.trollingcont.servicebuilder.service.persistence.PurchaseTypePersistence;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the employee right remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.trollingcont.servicebuilder.service.impl.EmployeeRightServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.trollingcont.servicebuilder.service.impl.EmployeeRightServiceImpl
 * @generated
 */
public abstract class EmployeeRightServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, EmployeeRightService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>EmployeeRightService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>EmployeeRightServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			EmployeeRightService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		employeeRightService = (EmployeeRightService)aopProxy;

		_setServiceUtilService(employeeRightService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EmployeeRightService.class.getName();
	}

	protected Class<?> getModelClass() {
		return EmployeeRight.class;
	}

	protected String getModelClassName() {
		return EmployeeRight.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = employeeRightPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(
		EmployeeRightService employeeRightService) {

		try {
			Field field = EmployeeRightServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, employeeRightService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ElectronicsPersistence electronicsPersistence;

	@Reference
	protected ElectronicsTypePersistence electronicsTypePersistence;

	@Reference
	protected EmployeePersistence employeePersistence;

	@Reference
	protected com.trollingcont.servicebuilder.service.EmployeeRightLocalService
		employeeRightLocalService;

	protected EmployeeRightService employeeRightService;

	@Reference
	protected EmployeeRightPersistence employeeRightPersistence;

	@Reference
	protected PostPersistence postPersistence;

	@Reference
	protected PurchasePersistence purchasePersistence;

	@Reference
	protected PurchaseTypePersistence purchaseTypePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}