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

package com.trollingcont.servicebuilder.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.trollingcont.servicebuilder.model.EmployeeRight;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the employee right service. This utility wraps <code>com.trollingcont.servicebuilder.service.persistence.impl.EmployeeRightPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeRightPersistence
 * @generated
 */
public class EmployeeRightUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(EmployeeRight employeeRight) {
		getPersistence().clearCache(employeeRight);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, EmployeeRight> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeRight> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeRight> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeRight> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeRight> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeRight update(EmployeeRight employeeRight) {
		return getPersistence().update(employeeRight);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeRight update(
		EmployeeRight employeeRight, ServiceContext serviceContext) {

		return getPersistence().update(employeeRight, serviceContext);
	}

	/**
	 * Returns all the employee rights where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee rights
	 */
	public static List<EmployeeRight> findByEmployeeRightsList(
		long employeeId) {

		return getPersistence().findByEmployeeRightsList(employeeId);
	}

	/**
	 * Returns a range of all the employee rights where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeRightModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee rights
	 * @param end the upper bound of the range of employee rights (not inclusive)
	 * @return the range of matching employee rights
	 */
	public static List<EmployeeRight> findByEmployeeRightsList(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeRightsList(
			employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee rights where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeRightModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee rights
	 * @param end the upper bound of the range of employee rights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee rights
	 */
	public static List<EmployeeRight> findByEmployeeRightsList(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeRight> orderByComparator) {

		return getPersistence().findByEmployeeRightsList(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee rights where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeRightModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee rights
	 * @param end the upper bound of the range of employee rights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee rights
	 */
	public static List<EmployeeRight> findByEmployeeRightsList(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeRight> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeRightsList(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee right in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee right
	 * @throws NoSuchEmployeeRightException if a matching employee right could not be found
	 */
	public static EmployeeRight findByEmployeeRightsList_First(
			long employeeId, OrderByComparator<EmployeeRight> orderByComparator)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchEmployeeRightException {

		return getPersistence().findByEmployeeRightsList_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee right in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee right, or <code>null</code> if a matching employee right could not be found
	 */
	public static EmployeeRight fetchByEmployeeRightsList_First(
		long employeeId, OrderByComparator<EmployeeRight> orderByComparator) {

		return getPersistence().fetchByEmployeeRightsList_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee right in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee right
	 * @throws NoSuchEmployeeRightException if a matching employee right could not be found
	 */
	public static EmployeeRight findByEmployeeRightsList_Last(
			long employeeId, OrderByComparator<EmployeeRight> orderByComparator)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchEmployeeRightException {

		return getPersistence().findByEmployeeRightsList_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee right in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee right, or <code>null</code> if a matching employee right could not be found
	 */
	public static EmployeeRight fetchByEmployeeRightsList_Last(
		long employeeId, OrderByComparator<EmployeeRight> orderByComparator) {

		return getPersistence().fetchByEmployeeRightsList_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee rights before and after the current employee right in the ordered set where employeeId = &#63;.
	 *
	 * @param rightId the primary key of the current employee right
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee right
	 * @throws NoSuchEmployeeRightException if a employee right with the primary key could not be found
	 */
	public static EmployeeRight[] findByEmployeeRightsList_PrevAndNext(
			long rightId, long employeeId,
			OrderByComparator<EmployeeRight> orderByComparator)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchEmployeeRightException {

		return getPersistence().findByEmployeeRightsList_PrevAndNext(
			rightId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee rights where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeRightsList(long employeeId) {
		getPersistence().removeByEmployeeRightsList(employeeId);
	}

	/**
	 * Returns the number of employee rights where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee rights
	 */
	public static int countByEmployeeRightsList(long employeeId) {
		return getPersistence().countByEmployeeRightsList(employeeId);
	}

	/**
	 * Returns all the employee rights where employeeId = &#63; and productTypeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 * @return the matching employee rights
	 */
	public static List<EmployeeRight> findByEmployeeSingleRight(
		long employeeId, long productTypeId) {

		return getPersistence().findByEmployeeSingleRight(
			employeeId, productTypeId);
	}

	/**
	 * Returns a range of all the employee rights where employeeId = &#63; and productTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeRightModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 * @param start the lower bound of the range of employee rights
	 * @param end the upper bound of the range of employee rights (not inclusive)
	 * @return the range of matching employee rights
	 */
	public static List<EmployeeRight> findByEmployeeSingleRight(
		long employeeId, long productTypeId, int start, int end) {

		return getPersistence().findByEmployeeSingleRight(
			employeeId, productTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee rights where employeeId = &#63; and productTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeRightModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 * @param start the lower bound of the range of employee rights
	 * @param end the upper bound of the range of employee rights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee rights
	 */
	public static List<EmployeeRight> findByEmployeeSingleRight(
		long employeeId, long productTypeId, int start, int end,
		OrderByComparator<EmployeeRight> orderByComparator) {

		return getPersistence().findByEmployeeSingleRight(
			employeeId, productTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee rights where employeeId = &#63; and productTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeRightModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 * @param start the lower bound of the range of employee rights
	 * @param end the upper bound of the range of employee rights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee rights
	 */
	public static List<EmployeeRight> findByEmployeeSingleRight(
		long employeeId, long productTypeId, int start, int end,
		OrderByComparator<EmployeeRight> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeSingleRight(
			employeeId, productTypeId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first employee right in the ordered set where employeeId = &#63; and productTypeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee right
	 * @throws NoSuchEmployeeRightException if a matching employee right could not be found
	 */
	public static EmployeeRight findByEmployeeSingleRight_First(
			long employeeId, long productTypeId,
			OrderByComparator<EmployeeRight> orderByComparator)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchEmployeeRightException {

		return getPersistence().findByEmployeeSingleRight_First(
			employeeId, productTypeId, orderByComparator);
	}

	/**
	 * Returns the first employee right in the ordered set where employeeId = &#63; and productTypeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee right, or <code>null</code> if a matching employee right could not be found
	 */
	public static EmployeeRight fetchByEmployeeSingleRight_First(
		long employeeId, long productTypeId,
		OrderByComparator<EmployeeRight> orderByComparator) {

		return getPersistence().fetchByEmployeeSingleRight_First(
			employeeId, productTypeId, orderByComparator);
	}

	/**
	 * Returns the last employee right in the ordered set where employeeId = &#63; and productTypeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee right
	 * @throws NoSuchEmployeeRightException if a matching employee right could not be found
	 */
	public static EmployeeRight findByEmployeeSingleRight_Last(
			long employeeId, long productTypeId,
			OrderByComparator<EmployeeRight> orderByComparator)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchEmployeeRightException {

		return getPersistence().findByEmployeeSingleRight_Last(
			employeeId, productTypeId, orderByComparator);
	}

	/**
	 * Returns the last employee right in the ordered set where employeeId = &#63; and productTypeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee right, or <code>null</code> if a matching employee right could not be found
	 */
	public static EmployeeRight fetchByEmployeeSingleRight_Last(
		long employeeId, long productTypeId,
		OrderByComparator<EmployeeRight> orderByComparator) {

		return getPersistence().fetchByEmployeeSingleRight_Last(
			employeeId, productTypeId, orderByComparator);
	}

	/**
	 * Returns the employee rights before and after the current employee right in the ordered set where employeeId = &#63; and productTypeId = &#63;.
	 *
	 * @param rightId the primary key of the current employee right
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee right
	 * @throws NoSuchEmployeeRightException if a employee right with the primary key could not be found
	 */
	public static EmployeeRight[] findByEmployeeSingleRight_PrevAndNext(
			long rightId, long employeeId, long productTypeId,
			OrderByComparator<EmployeeRight> orderByComparator)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchEmployeeRightException {

		return getPersistence().findByEmployeeSingleRight_PrevAndNext(
			rightId, employeeId, productTypeId, orderByComparator);
	}

	/**
	 * Removes all the employee rights where employeeId = &#63; and productTypeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 */
	public static void removeByEmployeeSingleRight(
		long employeeId, long productTypeId) {

		getPersistence().removeByEmployeeSingleRight(employeeId, productTypeId);
	}

	/**
	 * Returns the number of employee rights where employeeId = &#63; and productTypeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 * @return the number of matching employee rights
	 */
	public static int countByEmployeeSingleRight(
		long employeeId, long productTypeId) {

		return getPersistence().countByEmployeeSingleRight(
			employeeId, productTypeId);
	}

	/**
	 * Caches the employee right in the entity cache if it is enabled.
	 *
	 * @param employeeRight the employee right
	 */
	public static void cacheResult(EmployeeRight employeeRight) {
		getPersistence().cacheResult(employeeRight);
	}

	/**
	 * Caches the employee rights in the entity cache if it is enabled.
	 *
	 * @param employeeRights the employee rights
	 */
	public static void cacheResult(List<EmployeeRight> employeeRights) {
		getPersistence().cacheResult(employeeRights);
	}

	/**
	 * Creates a new employee right with the primary key. Does not add the employee right to the database.
	 *
	 * @param rightId the primary key for the new employee right
	 * @return the new employee right
	 */
	public static EmployeeRight create(long rightId) {
		return getPersistence().create(rightId);
	}

	/**
	 * Removes the employee right with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rightId the primary key of the employee right
	 * @return the employee right that was removed
	 * @throws NoSuchEmployeeRightException if a employee right with the primary key could not be found
	 */
	public static EmployeeRight remove(long rightId)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchEmployeeRightException {

		return getPersistence().remove(rightId);
	}

	public static EmployeeRight updateImpl(EmployeeRight employeeRight) {
		return getPersistence().updateImpl(employeeRight);
	}

	/**
	 * Returns the employee right with the primary key or throws a <code>NoSuchEmployeeRightException</code> if it could not be found.
	 *
	 * @param rightId the primary key of the employee right
	 * @return the employee right
	 * @throws NoSuchEmployeeRightException if a employee right with the primary key could not be found
	 */
	public static EmployeeRight findByPrimaryKey(long rightId)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchEmployeeRightException {

		return getPersistence().findByPrimaryKey(rightId);
	}

	/**
	 * Returns the employee right with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rightId the primary key of the employee right
	 * @return the employee right, or <code>null</code> if a employee right with the primary key could not be found
	 */
	public static EmployeeRight fetchByPrimaryKey(long rightId) {
		return getPersistence().fetchByPrimaryKey(rightId);
	}

	/**
	 * Returns all the employee rights.
	 *
	 * @return the employee rights
	 */
	public static List<EmployeeRight> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee rights.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeRightModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee rights
	 * @param end the upper bound of the range of employee rights (not inclusive)
	 * @return the range of employee rights
	 */
	public static List<EmployeeRight> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee rights.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeRightModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee rights
	 * @param end the upper bound of the range of employee rights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee rights
	 */
	public static List<EmployeeRight> findAll(
		int start, int end,
		OrderByComparator<EmployeeRight> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee rights.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeRightModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee rights
	 * @param end the upper bound of the range of employee rights (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee rights
	 */
	public static List<EmployeeRight> findAll(
		int start, int end, OrderByComparator<EmployeeRight> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee rights from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee rights.
	 *
	 * @return the number of employee rights
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeRightPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeRightPersistence, EmployeeRightPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeeRightPersistence.class);

		ServiceTracker<EmployeeRightPersistence, EmployeeRightPersistence>
			serviceTracker =
				new ServiceTracker
					<EmployeeRightPersistence, EmployeeRightPersistence>(
						bundle.getBundleContext(),
						EmployeeRightPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}