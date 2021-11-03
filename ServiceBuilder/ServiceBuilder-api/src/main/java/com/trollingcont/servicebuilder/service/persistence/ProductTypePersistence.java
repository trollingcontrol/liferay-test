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

import com.trollingcont.servicebuilder.exception.NoSuchProductTypeException;
import com.trollingcont.servicebuilder.model.ProductType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the product type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductTypeUtil
 * @generated
 */
@ProviderType
public interface ProductTypePersistence extends BasePersistence<ProductType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductTypeUtil} to access the product type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the product types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product types
	 */
	public java.util.List<ProductType> findByUuid(String uuid);

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
	public java.util.List<ProductType> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProductType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductType>
			orderByComparator);

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
	public java.util.List<ProductType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product type
	 * @throws NoSuchProductTypeException if a matching product type could not be found
	 */
	public ProductType findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductType>
				orderByComparator)
		throws NoSuchProductTypeException;

	/**
	 * Returns the first product type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product type, or <code>null</code> if a matching product type could not be found
	 */
	public ProductType fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductType>
			orderByComparator);

	/**
	 * Returns the last product type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product type
	 * @throws NoSuchProductTypeException if a matching product type could not be found
	 */
	public ProductType findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductType>
				orderByComparator)
		throws NoSuchProductTypeException;

	/**
	 * Returns the last product type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product type, or <code>null</code> if a matching product type could not be found
	 */
	public ProductType fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductType>
			orderByComparator);

	/**
	 * Returns the product types before and after the current product type in the ordered set where uuid = &#63;.
	 *
	 * @param productTypeId the primary key of the current product type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product type
	 * @throws NoSuchProductTypeException if a product type with the primary key could not be found
	 */
	public ProductType[] findByUuid_PrevAndNext(
			long productTypeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductType>
				orderByComparator)
		throws NoSuchProductTypeException;

	/**
	 * Removes all the product types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of product types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product types
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the product types where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching product types
	 */
	public java.util.List<ProductType> findByProductName(String name);

	/**
	 * Returns a range of all the product types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of product types
	 * @param end the upper bound of the range of product types (not inclusive)
	 * @return the range of matching product types
	 */
	public java.util.List<ProductType> findByProductName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the product types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of product types
	 * @param end the upper bound of the range of product types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product types
	 */
	public java.util.List<ProductType> findByProductName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of product types
	 * @param end the upper bound of the range of product types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product types
	 */
	public java.util.List<ProductType> findByProductName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product type
	 * @throws NoSuchProductTypeException if a matching product type could not be found
	 */
	public ProductType findByProductName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<ProductType>
				orderByComparator)
		throws NoSuchProductTypeException;

	/**
	 * Returns the first product type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product type, or <code>null</code> if a matching product type could not be found
	 */
	public ProductType fetchByProductName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<ProductType>
			orderByComparator);

	/**
	 * Returns the last product type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product type
	 * @throws NoSuchProductTypeException if a matching product type could not be found
	 */
	public ProductType findByProductName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<ProductType>
				orderByComparator)
		throws NoSuchProductTypeException;

	/**
	 * Returns the last product type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product type, or <code>null</code> if a matching product type could not be found
	 */
	public ProductType fetchByProductName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<ProductType>
			orderByComparator);

	/**
	 * Returns the product types before and after the current product type in the ordered set where name = &#63;.
	 *
	 * @param productTypeId the primary key of the current product type
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product type
	 * @throws NoSuchProductTypeException if a product type with the primary key could not be found
	 */
	public ProductType[] findByProductName_PrevAndNext(
			long productTypeId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<ProductType>
				orderByComparator)
		throws NoSuchProductTypeException;

	/**
	 * Removes all the product types where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByProductName(String name);

	/**
	 * Returns the number of product types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching product types
	 */
	public int countByProductName(String name);

	/**
	 * Caches the product type in the entity cache if it is enabled.
	 *
	 * @param productType the product type
	 */
	public void cacheResult(ProductType productType);

	/**
	 * Caches the product types in the entity cache if it is enabled.
	 *
	 * @param productTypes the product types
	 */
	public void cacheResult(java.util.List<ProductType> productTypes);

	/**
	 * Creates a new product type with the primary key. Does not add the product type to the database.
	 *
	 * @param productTypeId the primary key for the new product type
	 * @return the new product type
	 */
	public ProductType create(long productTypeId);

	/**
	 * Removes the product type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productTypeId the primary key of the product type
	 * @return the product type that was removed
	 * @throws NoSuchProductTypeException if a product type with the primary key could not be found
	 */
	public ProductType remove(long productTypeId)
		throws NoSuchProductTypeException;

	public ProductType updateImpl(ProductType productType);

	/**
	 * Returns the product type with the primary key or throws a <code>NoSuchProductTypeException</code> if it could not be found.
	 *
	 * @param productTypeId the primary key of the product type
	 * @return the product type
	 * @throws NoSuchProductTypeException if a product type with the primary key could not be found
	 */
	public ProductType findByPrimaryKey(long productTypeId)
		throws NoSuchProductTypeException;

	/**
	 * Returns the product type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productTypeId the primary key of the product type
	 * @return the product type, or <code>null</code> if a product type with the primary key could not be found
	 */
	public ProductType fetchByPrimaryKey(long productTypeId);

	/**
	 * Returns all the product types.
	 *
	 * @return the product types
	 */
	public java.util.List<ProductType> findAll();

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
	public java.util.List<ProductType> findAll(int start, int end);

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
	public java.util.List<ProductType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductType>
			orderByComparator);

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
	public java.util.List<ProductType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the product types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of product types.
	 *
	 * @return the number of product types
	 */
	public int countAll();

}