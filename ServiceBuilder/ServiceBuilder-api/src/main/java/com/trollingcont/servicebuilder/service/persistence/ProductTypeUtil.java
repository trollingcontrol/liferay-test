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

import com.trollingcont.servicebuilder.model.ProductType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the product type service. This utility wraps <code>com.trollingcont.servicebuilder.service.persistence.impl.ProductTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductTypePersistence
 * @generated
 */
public class ProductTypeUtil {

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
	public static void clearCache(ProductType productType) {
		getPersistence().clearCache(productType);
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
	public static Map<Serializable, ProductType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductType update(ProductType productType) {
		return getPersistence().update(productType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductType update(
		ProductType productType, ServiceContext serviceContext) {

		return getPersistence().update(productType, serviceContext);
	}

	/**
	 * Returns all the product types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product types
	 */
	public static List<ProductType> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the product types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product types
	 * @param end the upper bound of the range of product types (not inclusive)
	 * @return the range of matching product types
	 */
	public static List<ProductType> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the product types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product types
	 * @param end the upper bound of the range of product types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product types
	 */
	public static List<ProductType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductType> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product types
	 * @param end the upper bound of the range of product types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product types
	 */
	public static List<ProductType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product type
	 * @throws NoSuchProductTypeException if a matching product type could not be found
	 */
	public static ProductType findByUuid_First(
			String uuid, OrderByComparator<ProductType> orderByComparator)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchProductTypeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first product type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product type, or <code>null</code> if a matching product type could not be found
	 */
	public static ProductType fetchByUuid_First(
		String uuid, OrderByComparator<ProductType> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last product type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product type
	 * @throws NoSuchProductTypeException if a matching product type could not be found
	 */
	public static ProductType findByUuid_Last(
			String uuid, OrderByComparator<ProductType> orderByComparator)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchProductTypeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last product type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product type, or <code>null</code> if a matching product type could not be found
	 */
	public static ProductType fetchByUuid_Last(
		String uuid, OrderByComparator<ProductType> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the product types before and after the current product type in the ordered set where uuid = &#63;.
	 *
	 * @param productTypeId the primary key of the current product type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product type
	 * @throws NoSuchProductTypeException if a product type with the primary key could not be found
	 */
	public static ProductType[] findByUuid_PrevAndNext(
			long productTypeId, String uuid,
			OrderByComparator<ProductType> orderByComparator)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchProductTypeException {

		return getPersistence().findByUuid_PrevAndNext(
			productTypeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the product types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of product types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product types
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the product type in the entity cache if it is enabled.
	 *
	 * @param productType the product type
	 */
	public static void cacheResult(ProductType productType) {
		getPersistence().cacheResult(productType);
	}

	/**
	 * Caches the product types in the entity cache if it is enabled.
	 *
	 * @param productTypes the product types
	 */
	public static void cacheResult(List<ProductType> productTypes) {
		getPersistence().cacheResult(productTypes);
	}

	/**
	 * Creates a new product type with the primary key. Does not add the product type to the database.
	 *
	 * @param productTypeId the primary key for the new product type
	 * @return the new product type
	 */
	public static ProductType create(long productTypeId) {
		return getPersistence().create(productTypeId);
	}

	/**
	 * Removes the product type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productTypeId the primary key of the product type
	 * @return the product type that was removed
	 * @throws NoSuchProductTypeException if a product type with the primary key could not be found
	 */
	public static ProductType remove(long productTypeId)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchProductTypeException {

		return getPersistence().remove(productTypeId);
	}

	public static ProductType updateImpl(ProductType productType) {
		return getPersistence().updateImpl(productType);
	}

	/**
	 * Returns the product type with the primary key or throws a <code>NoSuchProductTypeException</code> if it could not be found.
	 *
	 * @param productTypeId the primary key of the product type
	 * @return the product type
	 * @throws NoSuchProductTypeException if a product type with the primary key could not be found
	 */
	public static ProductType findByPrimaryKey(long productTypeId)
		throws com.trollingcont.servicebuilder.exception.
			NoSuchProductTypeException {

		return getPersistence().findByPrimaryKey(productTypeId);
	}

	/**
	 * Returns the product type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productTypeId the primary key of the product type
	 * @return the product type, or <code>null</code> if a product type with the primary key could not be found
	 */
	public static ProductType fetchByPrimaryKey(long productTypeId) {
		return getPersistence().fetchByPrimaryKey(productTypeId);
	}

	/**
	 * Returns all the product types.
	 *
	 * @return the product types
	 */
	public static List<ProductType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the product types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product types
	 * @param end the upper bound of the range of product types (not inclusive)
	 * @return the range of product types
	 */
	public static List<ProductType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the product types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product types
	 * @param end the upper bound of the range of product types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product types
	 */
	public static List<ProductType> findAll(
		int start, int end, OrderByComparator<ProductType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product types
	 * @param end the upper bound of the range of product types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product types
	 */
	public static List<ProductType> findAll(
		int start, int end, OrderByComparator<ProductType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the product types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product types.
	 *
	 * @return the number of product types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProductTypePersistence, ProductTypePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProductTypePersistence.class);

		ServiceTracker<ProductTypePersistence, ProductTypePersistence>
			serviceTracker =
				new ServiceTracker
					<ProductTypePersistence, ProductTypePersistence>(
						bundle.getBundleContext(), ProductTypePersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}