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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.trollingcont.servicebuilder.exception.NoSuchEmployeeRightException;
import com.trollingcont.servicebuilder.model.EmployeeRight;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee right service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeRightUtil
 * @generated
 */
@ProviderType
public interface EmployeeRightPersistence
	extends BasePersistence<EmployeeRight> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeRightUtil} to access the employee right persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the employee right in the entity cache if it is enabled.
	 *
	 * @param employeeRight the employee right
	 */
	public void cacheResult(EmployeeRight employeeRight);

	/**
	 * Caches the employee rights in the entity cache if it is enabled.
	 *
	 * @param employeeRights the employee rights
	 */
	public void cacheResult(java.util.List<EmployeeRight> employeeRights);

	/**
	 * Creates a new employee right with the primary key. Does not add the employee right to the database.
	 *
	 * @param rightId the primary key for the new employee right
	 * @return the new employee right
	 */
	public EmployeeRight create(long rightId);

	/**
	 * Removes the employee right with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rightId the primary key of the employee right
	 * @return the employee right that was removed
	 * @throws NoSuchEmployeeRightException if a employee right with the primary key could not be found
	 */
	public EmployeeRight remove(long rightId)
		throws NoSuchEmployeeRightException;

	public EmployeeRight updateImpl(EmployeeRight employeeRight);

	/**
	 * Returns the employee right with the primary key or throws a <code>NoSuchEmployeeRightException</code> if it could not be found.
	 *
	 * @param rightId the primary key of the employee right
	 * @return the employee right
	 * @throws NoSuchEmployeeRightException if a employee right with the primary key could not be found
	 */
	public EmployeeRight findByPrimaryKey(long rightId)
		throws NoSuchEmployeeRightException;

	/**
	 * Returns the employee right with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rightId the primary key of the employee right
	 * @return the employee right, or <code>null</code> if a employee right with the primary key could not be found
	 */
	public EmployeeRight fetchByPrimaryKey(long rightId);

	/**
	 * Returns all the employee rights.
	 *
	 * @return the employee rights
	 */
	public java.util.List<EmployeeRight> findAll();

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
	public java.util.List<EmployeeRight> findAll(int start, int end);

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
	public java.util.List<EmployeeRight> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeRight>
			orderByComparator);

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
	public java.util.List<EmployeeRight> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeRight>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee rights from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee rights.
	 *
	 * @return the number of employee rights
	 */
	public int countAll();

}