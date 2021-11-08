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
 * Provides a wrapper for {@link EmployeeRightLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeRightLocalService
 * @generated
 */
public class EmployeeRightLocalServiceWrapper
	implements EmployeeRightLocalService,
			   ServiceWrapper<EmployeeRightLocalService> {

	public EmployeeRightLocalServiceWrapper(
		EmployeeRightLocalService employeeRightLocalService) {

		_employeeRightLocalService = employeeRightLocalService;
	}

	/**
	 * Adds the employee right to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeRightLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeRight the employee right
	 * @return the employee right that was added
	 */
	@Override
	public com.trollingcont.servicebuilder.model.EmployeeRight addEmployeeRight(
		com.trollingcont.servicebuilder.model.EmployeeRight employeeRight) {

		return _employeeRightLocalService.addEmployeeRight(employeeRight);
	}

	@Override
	public com.trollingcont.servicebuilder.model.EmployeeRight addEmployeeRight(
			long employeeId, long productTypeId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeRightLocalService.addEmployeeRight(
			employeeId, productTypeId, serviceContext);
	}

	/**
	 * Creates a new employee right with the primary key. Does not add the employee right to the database.
	 *
	 * @param rightId the primary key for the new employee right
	 * @return the new employee right
	 */
	@Override
	public com.trollingcont.servicebuilder.model.EmployeeRight
		createEmployeeRight(long rightId) {

		return _employeeRightLocalService.createEmployeeRight(rightId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeRightLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee right from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeRightLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeRight the employee right
	 * @return the employee right that was removed
	 */
	@Override
	public com.trollingcont.servicebuilder.model.EmployeeRight
		deleteEmployeeRight(
			com.trollingcont.servicebuilder.model.EmployeeRight employeeRight) {

		return _employeeRightLocalService.deleteEmployeeRight(employeeRight);
	}

	/**
	 * Deletes the employee right with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeRightLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rightId the primary key of the employee right
	 * @return the employee right that was removed
	 * @throws PortalException if a employee right with the primary key could not be found
	 */
	@Override
	public com.trollingcont.servicebuilder.model.EmployeeRight
			deleteEmployeeRight(long rightId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeRightLocalService.deleteEmployeeRight(rightId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeRightLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeRightLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _employeeRightLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.trollingcont.servicebuilder.model.impl.EmployeeRightModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _employeeRightLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.trollingcont.servicebuilder.model.impl.EmployeeRightModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _employeeRightLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _employeeRightLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _employeeRightLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.trollingcont.servicebuilder.model.EmployeeRight
		fetchEmployeeRight(long rightId) {

		return _employeeRightLocalService.fetchEmployeeRight(rightId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeRightLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee right with the primary key.
	 *
	 * @param rightId the primary key of the employee right
	 * @return the employee right
	 * @throws PortalException if a employee right with the primary key could not be found
	 */
	@Override
	public com.trollingcont.servicebuilder.model.EmployeeRight getEmployeeRight(
			long rightId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeRightLocalService.getEmployeeRight(rightId);
	}

	/**
	 * Returns a range of all the employee rights.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.trollingcont.servicebuilder.model.impl.EmployeeRightModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee rights
	 * @param end the upper bound of the range of employee rights (not inclusive)
	 * @return the range of employee rights
	 */
	@Override
	public java.util.List<com.trollingcont.servicebuilder.model.EmployeeRight>
		getEmployeeRights(int start, int end) {

		return _employeeRightLocalService.getEmployeeRights(start, end);
	}

	/**
	 * Returns the number of employee rights.
	 *
	 * @return the number of employee rights
	 */
	@Override
	public int getEmployeeRightsCount() {
		return _employeeRightLocalService.getEmployeeRightsCount();
	}

	@Override
	public java.util.List<com.trollingcont.servicebuilder.model.EmployeeRight>
			getEmployeeRightsList(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeRightLocalService.getEmployeeRightsList(employeeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeRightLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeRightLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeRightLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee right in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeRightLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeRight the employee right
	 * @return the employee right that was updated
	 */
	@Override
	public com.trollingcont.servicebuilder.model.EmployeeRight
		updateEmployeeRight(
			com.trollingcont.servicebuilder.model.EmployeeRight employeeRight) {

		return _employeeRightLocalService.updateEmployeeRight(employeeRight);
	}

	@Override
	public EmployeeRightLocalService getWrappedService() {
		return _employeeRightLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeRightLocalService employeeRightLocalService) {

		_employeeRightLocalService = employeeRightLocalService;
	}

	private EmployeeRightLocalService _employeeRightLocalService;

}