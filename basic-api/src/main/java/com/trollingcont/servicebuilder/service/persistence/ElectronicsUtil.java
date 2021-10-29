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

import com.trollingcont.servicebuilder.model.Electronics;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the electronics service. This utility wraps <code>com.trollingcont.servicebuilder.service.persistence.impl.ElectronicsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectronicsPersistence
 * @generated
 */
public class ElectronicsUtil {

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
	public static void clearCache(Electronics electronics) {
		getPersistence().clearCache(electronics);
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
	public static Map<Serializable, Electronics> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Electronics> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Electronics> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Electronics> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Electronics> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Electronics update(Electronics electronics) {
		return getPersistence().update(electronics);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Electronics update(
		Electronics electronics, ServiceContext serviceContext) {

		return getPersistence().update(electronics, serviceContext);
	}

	/**
	 * Returns all the electronicses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching electronicses
	 */
	public static List<Electronics> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the electronicses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @return the range of matching electronicses
	 */
	public static List<Electronics> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the electronicses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching electronicses
	 */
	public static List<Electronics> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Electronics> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the electronicses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching electronicses
	 */
	public static List<Electronics> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Electronics> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first electronics in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electronics
	 * @throws NoSuchElectronicsException if a matching electronics could not be found
	 */
	public static Electronics findByUuid_First(
			String uuid, OrderByComparator<Electronics> orderByComparator)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchElectronicsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first electronics in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electronics, or <code>null</code> if a matching electronics could not be found
	 */
	public static Electronics fetchByUuid_First(
		String uuid, OrderByComparator<Electronics> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last electronics in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electronics
	 * @throws NoSuchElectronicsException if a matching electronics could not be found
	 */
	public static Electronics findByUuid_Last(
			String uuid, OrderByComparator<Electronics> orderByComparator)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchElectronicsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last electronics in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electronics, or <code>null</code> if a matching electronics could not be found
	 */
	public static Electronics fetchByUuid_Last(
		String uuid, OrderByComparator<Electronics> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the electronicses before and after the current electronics in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current electronics
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next electronics
	 * @throws NoSuchElectronicsException if a electronics with the primary key could not be found
	 */
	public static Electronics[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<Electronics> orderByComparator)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchElectronicsException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the electronicses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of electronicses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching electronicses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the electronics in the entity cache if it is enabled.
	 *
	 * @param electronics the electronics
	 */
	public static void cacheResult(Electronics electronics) {
		getPersistence().cacheResult(electronics);
	}

	/**
	 * Caches the electronicses in the entity cache if it is enabled.
	 *
	 * @param electronicses the electronicses
	 */
	public static void cacheResult(List<Electronics> electronicses) {
		getPersistence().cacheResult(electronicses);
	}

	/**
	 * Creates a new electronics with the primary key. Does not add the electronics to the database.
	 *
	 * @param id the primary key for the new electronics
	 * @return the new electronics
	 */
	public static Electronics create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the electronics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the electronics
	 * @return the electronics that was removed
	 * @throws NoSuchElectronicsException if a electronics with the primary key could not be found
	 */
	public static Electronics remove(long id)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchElectronicsException {

		return getPersistence().remove(id);
	}

	public static Electronics updateImpl(Electronics electronics) {
		return getPersistence().updateImpl(electronics);
	}

	/**
	 * Returns the electronics with the primary key or throws a <code>NoSuchElectronicsException</code> if it could not be found.
	 *
	 * @param id the primary key of the electronics
	 * @return the electronics
	 * @throws NoSuchElectronicsException if a electronics with the primary key could not be found
	 */
	public static Electronics findByPrimaryKey(long id)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchElectronicsException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the electronics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the electronics
	 * @return the electronics, or <code>null</code> if a electronics with the primary key could not be found
	 */
	public static Electronics fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the electronicses.
	 *
	 * @return the electronicses
	 */
	public static List<Electronics> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the electronicses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @return the range of electronicses
	 */
	public static List<Electronics> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the electronicses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of electronicses
	 */
	public static List<Electronics> findAll(
		int start, int end, OrderByComparator<Electronics> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the electronicses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of electronicses
	 */
	public static List<Electronics> findAll(
		int start, int end, OrderByComparator<Electronics> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the electronicses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of electronicses.
	 *
	 * @return the number of electronicses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ElectronicsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ElectronicsPersistence, ElectronicsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ElectronicsPersistence.class);

		ServiceTracker<ElectronicsPersistence, ElectronicsPersistence>
			serviceTracker =
				new ServiceTracker
					<ElectronicsPersistence, ElectronicsPersistence>(
						bundle.getBundleContext(), ElectronicsPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}