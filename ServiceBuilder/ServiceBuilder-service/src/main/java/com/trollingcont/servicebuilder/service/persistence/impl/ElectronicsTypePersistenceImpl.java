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

package com.trollingcont.servicebuilder.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.trollingcont.servicebuilder.exception.NoSuchElectronicsTypeException;
import com.trollingcont.servicebuilder.model.ElectronicsType;
import com.trollingcont.servicebuilder.model.impl.ElectronicsTypeImpl;
import com.trollingcont.servicebuilder.model.impl.ElectronicsTypeModelImpl;
import com.trollingcont.servicebuilder.service.persistence.ElectronicsTypePersistence;
import com.trollingcont.servicebuilder.service.persistence.impl.constants.LSPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the electronics type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ElectronicsTypePersistence.class)
public class ElectronicsTypePersistenceImpl
	extends BasePersistenceImpl<ElectronicsType>
	implements ElectronicsTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ElectronicsTypeUtil</code> to access the electronics type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ElectronicsTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the electronics types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching electronics types
	 */
	@Override
	public List<ElectronicsType> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ElectronicsType> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<ElectronicsType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElectronicsType> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ElectronicsType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElectronicsType> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<ElectronicsType> list = null;

		if (useFinderCache) {
			list = (List<ElectronicsType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElectronicsType electronicsType : list) {
					if (!uuid.equals(electronicsType.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ELECTRONICSTYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElectronicsTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<ElectronicsType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first electronics type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electronics type
	 * @throws NoSuchElectronicsTypeException if a matching electronics type could not be found
	 */
	@Override
	public ElectronicsType findByUuid_First(
			String uuid, OrderByComparator<ElectronicsType> orderByComparator)
		throws NoSuchElectronicsTypeException {

		ElectronicsType electronicsType = fetchByUuid_First(
			uuid, orderByComparator);

		if (electronicsType != null) {
			return electronicsType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchElectronicsTypeException(sb.toString());
	}

	/**
	 * Returns the first electronics type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electronics type, or <code>null</code> if a matching electronics type could not be found
	 */
	@Override
	public ElectronicsType fetchByUuid_First(
		String uuid, OrderByComparator<ElectronicsType> orderByComparator) {

		List<ElectronicsType> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last electronics type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electronics type
	 * @throws NoSuchElectronicsTypeException if a matching electronics type could not be found
	 */
	@Override
	public ElectronicsType findByUuid_Last(
			String uuid, OrderByComparator<ElectronicsType> orderByComparator)
		throws NoSuchElectronicsTypeException {

		ElectronicsType electronicsType = fetchByUuid_Last(
			uuid, orderByComparator);

		if (electronicsType != null) {
			return electronicsType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchElectronicsTypeException(sb.toString());
	}

	/**
	 * Returns the last electronics type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electronics type, or <code>null</code> if a matching electronics type could not be found
	 */
	@Override
	public ElectronicsType fetchByUuid_Last(
		String uuid, OrderByComparator<ElectronicsType> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ElectronicsType> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the electronics types before and after the current electronics type in the ordered set where uuid = &#63;.
	 *
	 * @param productTypeId the primary key of the current electronics type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next electronics type
	 * @throws NoSuchElectronicsTypeException if a electronics type with the primary key could not be found
	 */
	@Override
	public ElectronicsType[] findByUuid_PrevAndNext(
			long productTypeId, String uuid,
			OrderByComparator<ElectronicsType> orderByComparator)
		throws NoSuchElectronicsTypeException {

		uuid = Objects.toString(uuid, "");

		ElectronicsType electronicsType = findByPrimaryKey(productTypeId);

		Session session = null;

		try {
			session = openSession();

			ElectronicsType[] array = new ElectronicsTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, electronicsType, uuid, orderByComparator, true);

			array[1] = electronicsType;

			array[2] = getByUuid_PrevAndNext(
				session, electronicsType, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElectronicsType getByUuid_PrevAndNext(
		Session session, ElectronicsType electronicsType, String uuid,
		OrderByComparator<ElectronicsType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ELECTRONICSTYPE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ElectronicsTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						electronicsType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElectronicsType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the electronics types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ElectronicsType electronicsType :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(electronicsType);
		}
	}

	/**
	 * Returns the number of electronics types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching electronics types
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELECTRONICSTYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"electronicsType.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(electronicsType.uuid IS NULL OR electronicsType.uuid = '')";

	public ElectronicsTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ElectronicsType.class);

		setModelImplClass(ElectronicsTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the electronics type in the entity cache if it is enabled.
	 *
	 * @param electronicsType the electronics type
	 */
	@Override
	public void cacheResult(ElectronicsType electronicsType) {
		entityCache.putResult(
			ElectronicsTypeImpl.class, electronicsType.getPrimaryKey(),
			electronicsType);
	}

	/**
	 * Caches the electronics types in the entity cache if it is enabled.
	 *
	 * @param electronicsTypes the electronics types
	 */
	@Override
	public void cacheResult(List<ElectronicsType> electronicsTypes) {
		for (ElectronicsType electronicsType : electronicsTypes) {
			if (entityCache.getResult(
					ElectronicsTypeImpl.class,
					electronicsType.getPrimaryKey()) == null) {

				cacheResult(electronicsType);
			}
		}
	}

	/**
	 * Clears the cache for all electronics types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ElectronicsTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the electronics type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ElectronicsType electronicsType) {
		entityCache.removeResult(ElectronicsTypeImpl.class, electronicsType);
	}

	@Override
	public void clearCache(List<ElectronicsType> electronicsTypes) {
		for (ElectronicsType electronicsType : electronicsTypes) {
			entityCache.removeResult(
				ElectronicsTypeImpl.class, electronicsType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ElectronicsTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new electronics type with the primary key. Does not add the electronics type to the database.
	 *
	 * @param productTypeId the primary key for the new electronics type
	 * @return the new electronics type
	 */
	@Override
	public ElectronicsType create(long productTypeId) {
		ElectronicsType electronicsType = new ElectronicsTypeImpl();

		electronicsType.setNew(true);
		electronicsType.setPrimaryKey(productTypeId);

		String uuid = PortalUUIDUtil.generate();

		electronicsType.setUuid(uuid);

		return electronicsType;
	}

	/**
	 * Removes the electronics type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productTypeId the primary key of the electronics type
	 * @return the electronics type that was removed
	 * @throws NoSuchElectronicsTypeException if a electronics type with the primary key could not be found
	 */
	@Override
	public ElectronicsType remove(long productTypeId)
		throws NoSuchElectronicsTypeException {

		return remove((Serializable)productTypeId);
	}

	/**
	 * Removes the electronics type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the electronics type
	 * @return the electronics type that was removed
	 * @throws NoSuchElectronicsTypeException if a electronics type with the primary key could not be found
	 */
	@Override
	public ElectronicsType remove(Serializable primaryKey)
		throws NoSuchElectronicsTypeException {

		Session session = null;

		try {
			session = openSession();

			ElectronicsType electronicsType = (ElectronicsType)session.get(
				ElectronicsTypeImpl.class, primaryKey);

			if (electronicsType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchElectronicsTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(electronicsType);
		}
		catch (NoSuchElectronicsTypeException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ElectronicsType removeImpl(ElectronicsType electronicsType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(electronicsType)) {
				electronicsType = (ElectronicsType)session.get(
					ElectronicsTypeImpl.class,
					electronicsType.getPrimaryKeyObj());
			}

			if (electronicsType != null) {
				session.delete(electronicsType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (electronicsType != null) {
			clearCache(electronicsType);
		}

		return electronicsType;
	}

	@Override
	public ElectronicsType updateImpl(ElectronicsType electronicsType) {
		boolean isNew = electronicsType.isNew();

		if (!(electronicsType instanceof ElectronicsTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(electronicsType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					electronicsType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in electronicsType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ElectronicsType implementation " +
					electronicsType.getClass());
		}

		ElectronicsTypeModelImpl electronicsTypeModelImpl =
			(ElectronicsTypeModelImpl)electronicsType;

		if (Validator.isNull(electronicsType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			electronicsType.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(electronicsType);
			}
			else {
				electronicsType = (ElectronicsType)session.merge(
					electronicsType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ElectronicsTypeImpl.class, electronicsTypeModelImpl, false, true);

		if (isNew) {
			electronicsType.setNew(false);
		}

		electronicsType.resetOriginalValues();

		return electronicsType;
	}

	/**
	 * Returns the electronics type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the electronics type
	 * @return the electronics type
	 * @throws NoSuchElectronicsTypeException if a electronics type with the primary key could not be found
	 */
	@Override
	public ElectronicsType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchElectronicsTypeException {

		ElectronicsType electronicsType = fetchByPrimaryKey(primaryKey);

		if (electronicsType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchElectronicsTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return electronicsType;
	}

	/**
	 * Returns the electronics type with the primary key or throws a <code>NoSuchElectronicsTypeException</code> if it could not be found.
	 *
	 * @param productTypeId the primary key of the electronics type
	 * @return the electronics type
	 * @throws NoSuchElectronicsTypeException if a electronics type with the primary key could not be found
	 */
	@Override
	public ElectronicsType findByPrimaryKey(long productTypeId)
		throws NoSuchElectronicsTypeException {

		return findByPrimaryKey((Serializable)productTypeId);
	}

	/**
	 * Returns the electronics type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productTypeId the primary key of the electronics type
	 * @return the electronics type, or <code>null</code> if a electronics type with the primary key could not be found
	 */
	@Override
	public ElectronicsType fetchByPrimaryKey(long productTypeId) {
		return fetchByPrimaryKey((Serializable)productTypeId);
	}

	/**
	 * Returns all the electronics types.
	 *
	 * @return the electronics types
	 */
	@Override
	public List<ElectronicsType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ElectronicsType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ElectronicsType> findAll(
		int start, int end,
		OrderByComparator<ElectronicsType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ElectronicsType> findAll(
		int start, int end,
		OrderByComparator<ElectronicsType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ElectronicsType> list = null;

		if (useFinderCache) {
			list = (List<ElectronicsType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ELECTRONICSTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ELECTRONICSTYPE;

				sql = sql.concat(ElectronicsTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ElectronicsType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the electronics types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ElectronicsType electronicsType : findAll()) {
			remove(electronicsType);
		}
	}

	/**
	 * Returns the number of electronics types.
	 *
	 * @return the number of electronics types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ELECTRONICSTYPE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "productTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ELECTRONICSTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ElectronicsTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the electronics type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ElectronicsTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ElectronicsType.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ElectronicsTypeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = LSPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = LSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = LSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ELECTRONICSTYPE =
		"SELECT electronicsType FROM ElectronicsType electronicsType";

	private static final String _SQL_SELECT_ELECTRONICSTYPE_WHERE =
		"SELECT electronicsType FROM ElectronicsType electronicsType WHERE ";

	private static final String _SQL_COUNT_ELECTRONICSTYPE =
		"SELECT COUNT(electronicsType) FROM ElectronicsType electronicsType";

	private static final String _SQL_COUNT_ELECTRONICSTYPE_WHERE =
		"SELECT COUNT(electronicsType) FROM ElectronicsType electronicsType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "electronicsType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ElectronicsType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ElectronicsType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ElectronicsTypePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class ElectronicsTypeModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			ElectronicsTypeModelImpl electronicsTypeModelImpl =
				(ElectronicsTypeModelImpl)baseModel;

			long columnBitmask = electronicsTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					electronicsTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						electronicsTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					electronicsTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ElectronicsTypeModelImpl electronicsTypeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						electronicsTypeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = electronicsTypeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}