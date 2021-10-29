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

import com.trollingcont.servicebuilder.exception.NoSuchElectronicsTypeException;
import com.trollingcont.servicebuilder.model.ElectronicsType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the electronics type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectronicsTypeUtil
 * @generated
 */
@ProviderType
public interface ElectronicsTypePersistence
	extends BasePersistence<ElectronicsType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ElectronicsTypeUtil} to access the electronics type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the electronics types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching electronics types
	 */
	public java.util.List<ElectronicsType> findByUuid(String uuid);

	/**
	 * Returns a range of all the electronics types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of electronics types
	 * @param end the upper bound of the range of electronics types (not inclusive)
	 * @return the range of matching electronics types
	 */
	public java.util.List<ElectronicsType> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the electronics types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of electronics types
	 * @param end the upper bound of the range of electronics types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching electronics types
	 */
	public java.util.List<ElectronicsType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectronicsType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the electronics types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of electronics types
	 * @param end the upper bound of the range of electronics types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching electronics types
	 */
	public java.util.List<ElectronicsType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectronicsType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first electronics type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electronics type
	 * @throws NoSuchElectronicsTypeException if a matching electronics type could not be found
	 */
	public ElectronicsType findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ElectronicsType>
				orderByComparator)
		throws NoSuchElectronicsTypeException;

	/**
	 * Returns the first electronics type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electronics type, or <code>null</code> if a matching electronics type could not be found
	 */
	public ElectronicsType fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ElectronicsType>
			orderByComparator);

	/**
	 * Returns the last electronics type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electronics type
	 * @throws NoSuchElectronicsTypeException if a matching electronics type could not be found
	 */
	public ElectronicsType findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ElectronicsType>
				orderByComparator)
		throws NoSuchElectronicsTypeException;

	/**
	 * Returns the last electronics type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electronics type, or <code>null</code> if a matching electronics type could not be found
	 */
	public ElectronicsType fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ElectronicsType>
			orderByComparator);

	/**
	 * Returns the electronics types before and after the current electronics type in the ordered set where uuid = &#63;.
	 *
	 * @param productTypeId the primary key of the current electronics type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next electronics type
	 * @throws NoSuchElectronicsTypeException if a electronics type with the primary key could not be found
	 */
	public ElectronicsType[] findByUuid_PrevAndNext(
			long productTypeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ElectronicsType>
				orderByComparator)
		throws NoSuchElectronicsTypeException;

	/**
	 * Removes all the electronics types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of electronics types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching electronics types
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the electronics type in the entity cache if it is enabled.
	 *
	 * @param electronicsType the electronics type
	 */
	public void cacheResult(ElectronicsType electronicsType);

	/**
	 * Caches the electronics types in the entity cache if it is enabled.
	 *
	 * @param electronicsTypes the electronics types
	 */
	public void cacheResult(java.util.List<ElectronicsType> electronicsTypes);

	/**
	 * Creates a new electronics type with the primary key. Does not add the electronics type to the database.
	 *
	 * @param productTypeId the primary key for the new electronics type
	 * @return the new electronics type
	 */
	public ElectronicsType create(long productTypeId);

	/**
	 * Removes the electronics type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productTypeId the primary key of the electronics type
	 * @return the electronics type that was removed
	 * @throws NoSuchElectronicsTypeException if a electronics type with the primary key could not be found
	 */
	public ElectronicsType remove(long productTypeId)
		throws NoSuchElectronicsTypeException;

	public ElectronicsType updateImpl(ElectronicsType electronicsType);

	/**
	 * Returns the electronics type with the primary key or throws a <code>NoSuchElectronicsTypeException</code> if it could not be found.
	 *
	 * @param productTypeId the primary key of the electronics type
	 * @return the electronics type
	 * @throws NoSuchElectronicsTypeException if a electronics type with the primary key could not be found
	 */
	public ElectronicsType findByPrimaryKey(long productTypeId)
		throws NoSuchElectronicsTypeException;

	/**
	 * Returns the electronics type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productTypeId the primary key of the electronics type
	 * @return the electronics type, or <code>null</code> if a electronics type with the primary key could not be found
	 */
	public ElectronicsType fetchByPrimaryKey(long productTypeId);

	/**
	 * Returns all the electronics types.
	 *
	 * @return the electronics types
	 */
	public java.util.List<ElectronicsType> findAll();

	/**
	 * Returns a range of all the electronics types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronics types
	 * @param end the upper bound of the range of electronics types (not inclusive)
	 * @return the range of electronics types
	 */
	public java.util.List<ElectronicsType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the electronics types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronics types
	 * @param end the upper bound of the range of electronics types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of electronics types
	 */
	public java.util.List<ElectronicsType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectronicsType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the electronics types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronics types
	 * @param end the upper bound of the range of electronics types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of electronics types
	 */
	public java.util.List<ElectronicsType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectronicsType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the electronics types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of electronics types.
	 *
	 * @return the number of electronics types
	 */
	public int countAll();

}