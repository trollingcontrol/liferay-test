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

import com.trollingcont.servicebuilder.model.PurchaseType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the purchase type service. This utility wraps <code>com.trollingcont.servicebuilder.service.persistence.impl.PurchaseTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PurchaseTypePersistence
 * @generated
 */
public class PurchaseTypeUtil {

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
	public static void clearCache(PurchaseType purchaseType) {
		getPersistence().clearCache(purchaseType);
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
	public static Map<Serializable, PurchaseType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PurchaseType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PurchaseType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PurchaseType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PurchaseType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PurchaseType update(PurchaseType purchaseType) {
		return getPersistence().update(purchaseType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PurchaseType update(
		PurchaseType purchaseType, ServiceContext serviceContext) {

		return getPersistence().update(purchaseType, serviceContext);
	}

	/**
	 * Returns all the purchase types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching purchase types
	 */
	public static List<PurchaseType> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the purchase types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @return the range of matching purchase types
	 */
	public static List<PurchaseType> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the purchase types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchase types
	 */
	public static List<PurchaseType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PurchaseType> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the purchase types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchase types
	 */
	public static List<PurchaseType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PurchaseType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first purchase type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase type
	 * @throws NoSuchPurchaseTypeException if a matching purchase type could not be found
	 */
	public static PurchaseType findByUuid_First(
			String uuid, OrderByComparator<PurchaseType> orderByComparator)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchPurchaseTypeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first purchase type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase type, or <code>null</code> if a matching purchase type could not be found
	 */
	public static PurchaseType fetchByUuid_First(
		String uuid, OrderByComparator<PurchaseType> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last purchase type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase type
	 * @throws NoSuchPurchaseTypeException if a matching purchase type could not be found
	 */
	public static PurchaseType findByUuid_Last(
			String uuid, OrderByComparator<PurchaseType> orderByComparator)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchPurchaseTypeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last purchase type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase type, or <code>null</code> if a matching purchase type could not be found
	 */
	public static PurchaseType fetchByUuid_Last(
		String uuid, OrderByComparator<PurchaseType> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the purchase types before and after the current purchase type in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current purchase type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase type
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	public static PurchaseType[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<PurchaseType> orderByComparator)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchPurchaseTypeException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the purchase types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of purchase types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching purchase types
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the purchase type in the entity cache if it is enabled.
	 *
	 * @param purchaseType the purchase type
	 */
	public static void cacheResult(PurchaseType purchaseType) {
		getPersistence().cacheResult(purchaseType);
	}

	/**
	 * Caches the purchase types in the entity cache if it is enabled.
	 *
	 * @param purchaseTypes the purchase types
	 */
	public static void cacheResult(List<PurchaseType> purchaseTypes) {
		getPersistence().cacheResult(purchaseTypes);
	}

	/**
	 * Creates a new purchase type with the primary key. Does not add the purchase type to the database.
	 *
	 * @param id the primary key for the new purchase type
	 * @return the new purchase type
	 */
	public static PurchaseType create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the purchase type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the purchase type
	 * @return the purchase type that was removed
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	public static PurchaseType remove(long id)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchPurchaseTypeException {

		return getPersistence().remove(id);
	}

	public static PurchaseType updateImpl(PurchaseType purchaseType) {
		return getPersistence().updateImpl(purchaseType);
	}

	/**
	 * Returns the purchase type with the primary key or throws a <code>NoSuchPurchaseTypeException</code> if it could not be found.
	 *
	 * @param id the primary key of the purchase type
	 * @return the purchase type
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	public static PurchaseType findByPrimaryKey(long id)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchPurchaseTypeException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the purchase type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the purchase type
	 * @return the purchase type, or <code>null</code> if a purchase type with the primary key could not be found
	 */
	public static PurchaseType fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the purchase types.
	 *
	 * @return the purchase types
	 */
	public static List<PurchaseType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the purchase types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @return the range of purchase types
	 */
	public static List<PurchaseType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the purchase types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of purchase types
	 */
	public static List<PurchaseType> findAll(
		int start, int end, OrderByComparator<PurchaseType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the purchase types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of purchase types
	 */
	public static List<PurchaseType> findAll(
		int start, int end, OrderByComparator<PurchaseType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the purchase types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of purchase types.
	 *
	 * @return the number of purchase types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PurchaseTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PurchaseTypePersistence, PurchaseTypePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PurchaseTypePersistence.class);

		ServiceTracker<PurchaseTypePersistence, PurchaseTypePersistence>
			serviceTracker =
				new ServiceTracker
					<PurchaseTypePersistence, PurchaseTypePersistence>(
						bundle.getBundleContext(),
						PurchaseTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}