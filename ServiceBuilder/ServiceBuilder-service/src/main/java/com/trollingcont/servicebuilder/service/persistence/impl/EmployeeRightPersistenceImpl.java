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

import com.trollingcont.servicebuilder.exception.NoSuchEmployeeRightException;
import com.trollingcont.servicebuilder.model.EmployeeRight;
import com.trollingcont.servicebuilder.model.impl.EmployeeRightImpl;
import com.trollingcont.servicebuilder.model.impl.EmployeeRightModelImpl;
import com.trollingcont.servicebuilder.service.persistence.EmployeeRightPersistence;
import com.trollingcont.servicebuilder.service.persistence.impl.constants.LSPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
 * The persistence implementation for the employee right service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeeRightPersistence.class)
public class EmployeeRightPersistenceImpl
	extends BasePersistenceImpl<EmployeeRight>
	implements EmployeeRightPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeRightUtil</code> to access the employee right persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeRightImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByEmployeeRightsList;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeRightsList;
	private FinderPath _finderPathCountByEmployeeRightsList;

	/**
	 * Returns all the employee rights where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee rights
	 */
	@Override
	public List<EmployeeRight> findByEmployeeRightsList(long employeeId) {
		return findByEmployeeRightsList(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EmployeeRight> findByEmployeeRightsList(
		long employeeId, int start, int end) {

		return findByEmployeeRightsList(employeeId, start, end, null);
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
	@Override
	public List<EmployeeRight> findByEmployeeRightsList(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeRight> orderByComparator) {

		return findByEmployeeRightsList(
			employeeId, start, end, orderByComparator, true);
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
	@Override
	public List<EmployeeRight> findByEmployeeRightsList(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeRight> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByEmployeeRightsList;
				finderArgs = new Object[] {employeeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmployeeRightsList;
			finderArgs = new Object[] {
				employeeId, start, end, orderByComparator
			};
		}

		List<EmployeeRight> list = null;

		if (useFinderCache) {
			list = (List<EmployeeRight>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeRight employeeRight : list) {
					if (employeeId != employeeRight.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_EMPLOYEERIGHT_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEERIGHTSLIST_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeRightModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<EmployeeRight>)QueryUtil.list(
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
	 * Returns the first employee right in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee right
	 * @throws NoSuchEmployeeRightException if a matching employee right could not be found
	 */
	@Override
	public EmployeeRight findByEmployeeRightsList_First(
			long employeeId, OrderByComparator<EmployeeRight> orderByComparator)
		throws NoSuchEmployeeRightException {

		EmployeeRight employeeRight = fetchByEmployeeRightsList_First(
			employeeId, orderByComparator);

		if (employeeRight != null) {
			return employeeRight;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeRightException(sb.toString());
	}

	/**
	 * Returns the first employee right in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee right, or <code>null</code> if a matching employee right could not be found
	 */
	@Override
	public EmployeeRight fetchByEmployeeRightsList_First(
		long employeeId, OrderByComparator<EmployeeRight> orderByComparator) {

		List<EmployeeRight> list = findByEmployeeRightsList(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee right in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee right
	 * @throws NoSuchEmployeeRightException if a matching employee right could not be found
	 */
	@Override
	public EmployeeRight findByEmployeeRightsList_Last(
			long employeeId, OrderByComparator<EmployeeRight> orderByComparator)
		throws NoSuchEmployeeRightException {

		EmployeeRight employeeRight = fetchByEmployeeRightsList_Last(
			employeeId, orderByComparator);

		if (employeeRight != null) {
			return employeeRight;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeRightException(sb.toString());
	}

	/**
	 * Returns the last employee right in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee right, or <code>null</code> if a matching employee right could not be found
	 */
	@Override
	public EmployeeRight fetchByEmployeeRightsList_Last(
		long employeeId, OrderByComparator<EmployeeRight> orderByComparator) {

		int count = countByEmployeeRightsList(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeRight> list = findByEmployeeRightsList(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EmployeeRight[] findByEmployeeRightsList_PrevAndNext(
			long rightId, long employeeId,
			OrderByComparator<EmployeeRight> orderByComparator)
		throws NoSuchEmployeeRightException {

		EmployeeRight employeeRight = findByPrimaryKey(rightId);

		Session session = null;

		try {
			session = openSession();

			EmployeeRight[] array = new EmployeeRightImpl[3];

			array[0] = getByEmployeeRightsList_PrevAndNext(
				session, employeeRight, employeeId, orderByComparator, true);

			array[1] = employeeRight;

			array[2] = getByEmployeeRightsList_PrevAndNext(
				session, employeeRight, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeRight getByEmployeeRightsList_PrevAndNext(
		Session session, EmployeeRight employeeRight, long employeeId,
		OrderByComparator<EmployeeRight> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMPLOYEERIGHT_WHERE);

		sb.append(_FINDER_COLUMN_EMPLOYEERIGHTSLIST_EMPLOYEEID_2);

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
			sb.append(EmployeeRightModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeRight)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeRight> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee rights where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeRightsList(long employeeId) {
		for (EmployeeRight employeeRight :
				findByEmployeeRightsList(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeRight);
		}
	}

	/**
	 * Returns the number of employee rights where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee rights
	 */
	@Override
	public int countByEmployeeRightsList(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeRightsList;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEERIGHT_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEERIGHTSLIST_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

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

	private static final String _FINDER_COLUMN_EMPLOYEERIGHTSLIST_EMPLOYEEID_2 =
		"employeeRight.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeSingleRight;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeSingleRight;
	private FinderPath _finderPathCountByEmployeeSingleRight;

	/**
	 * Returns all the employee rights where employeeId = &#63; and productTypeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 * @return the matching employee rights
	 */
	@Override
	public List<EmployeeRight> findByEmployeeSingleRight(
		long employeeId, long productTypeId) {

		return findByEmployeeSingleRight(
			employeeId, productTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<EmployeeRight> findByEmployeeSingleRight(
		long employeeId, long productTypeId, int start, int end) {

		return findByEmployeeSingleRight(
			employeeId, productTypeId, start, end, null);
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
	@Override
	public List<EmployeeRight> findByEmployeeSingleRight(
		long employeeId, long productTypeId, int start, int end,
		OrderByComparator<EmployeeRight> orderByComparator) {

		return findByEmployeeSingleRight(
			employeeId, productTypeId, start, end, orderByComparator, true);
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
	@Override
	public List<EmployeeRight> findByEmployeeSingleRight(
		long employeeId, long productTypeId, int start, int end,
		OrderByComparator<EmployeeRight> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByEmployeeSingleRight;
				finderArgs = new Object[] {employeeId, productTypeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmployeeSingleRight;
			finderArgs = new Object[] {
				employeeId, productTypeId, start, end, orderByComparator
			};
		}

		List<EmployeeRight> list = null;

		if (useFinderCache) {
			list = (List<EmployeeRight>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeRight employeeRight : list) {
					if ((employeeId != employeeRight.getEmployeeId()) ||
						(productTypeId != employeeRight.getProductTypeId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_EMPLOYEERIGHT_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEESINGLERIGHT_EMPLOYEEID_2);

			sb.append(_FINDER_COLUMN_EMPLOYEESINGLERIGHT_PRODUCTTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeRightModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				queryPos.add(productTypeId);

				list = (List<EmployeeRight>)QueryUtil.list(
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
	 * Returns the first employee right in the ordered set where employeeId = &#63; and productTypeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee right
	 * @throws NoSuchEmployeeRightException if a matching employee right could not be found
	 */
	@Override
	public EmployeeRight findByEmployeeSingleRight_First(
			long employeeId, long productTypeId,
			OrderByComparator<EmployeeRight> orderByComparator)
		throws NoSuchEmployeeRightException {

		EmployeeRight employeeRight = fetchByEmployeeSingleRight_First(
			employeeId, productTypeId, orderByComparator);

		if (employeeRight != null) {
			return employeeRight;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append(", productTypeId=");
		sb.append(productTypeId);

		sb.append("}");

		throw new NoSuchEmployeeRightException(sb.toString());
	}

	/**
	 * Returns the first employee right in the ordered set where employeeId = &#63; and productTypeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee right, or <code>null</code> if a matching employee right could not be found
	 */
	@Override
	public EmployeeRight fetchByEmployeeSingleRight_First(
		long employeeId, long productTypeId,
		OrderByComparator<EmployeeRight> orderByComparator) {

		List<EmployeeRight> list = findByEmployeeSingleRight(
			employeeId, productTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EmployeeRight findByEmployeeSingleRight_Last(
			long employeeId, long productTypeId,
			OrderByComparator<EmployeeRight> orderByComparator)
		throws NoSuchEmployeeRightException {

		EmployeeRight employeeRight = fetchByEmployeeSingleRight_Last(
			employeeId, productTypeId, orderByComparator);

		if (employeeRight != null) {
			return employeeRight;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append(", productTypeId=");
		sb.append(productTypeId);

		sb.append("}");

		throw new NoSuchEmployeeRightException(sb.toString());
	}

	/**
	 * Returns the last employee right in the ordered set where employeeId = &#63; and productTypeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee right, or <code>null</code> if a matching employee right could not be found
	 */
	@Override
	public EmployeeRight fetchByEmployeeSingleRight_Last(
		long employeeId, long productTypeId,
		OrderByComparator<EmployeeRight> orderByComparator) {

		int count = countByEmployeeSingleRight(employeeId, productTypeId);

		if (count == 0) {
			return null;
		}

		List<EmployeeRight> list = findByEmployeeSingleRight(
			employeeId, productTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EmployeeRight[] findByEmployeeSingleRight_PrevAndNext(
			long rightId, long employeeId, long productTypeId,
			OrderByComparator<EmployeeRight> orderByComparator)
		throws NoSuchEmployeeRightException {

		EmployeeRight employeeRight = findByPrimaryKey(rightId);

		Session session = null;

		try {
			session = openSession();

			EmployeeRight[] array = new EmployeeRightImpl[3];

			array[0] = getByEmployeeSingleRight_PrevAndNext(
				session, employeeRight, employeeId, productTypeId,
				orderByComparator, true);

			array[1] = employeeRight;

			array[2] = getByEmployeeSingleRight_PrevAndNext(
				session, employeeRight, employeeId, productTypeId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeRight getByEmployeeSingleRight_PrevAndNext(
		Session session, EmployeeRight employeeRight, long employeeId,
		long productTypeId, OrderByComparator<EmployeeRight> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EMPLOYEERIGHT_WHERE);

		sb.append(_FINDER_COLUMN_EMPLOYEESINGLERIGHT_EMPLOYEEID_2);

		sb.append(_FINDER_COLUMN_EMPLOYEESINGLERIGHT_PRODUCTTYPEID_2);

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
			sb.append(EmployeeRightModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		queryPos.add(productTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeRight)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeRight> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee rights where employeeId = &#63; and productTypeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 */
	@Override
	public void removeByEmployeeSingleRight(
		long employeeId, long productTypeId) {

		for (EmployeeRight employeeRight :
				findByEmployeeSingleRight(
					employeeId, productTypeId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(employeeRight);
		}
	}

	/**
	 * Returns the number of employee rights where employeeId = &#63; and productTypeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param productTypeId the product type ID
	 * @return the number of matching employee rights
	 */
	@Override
	public int countByEmployeeSingleRight(long employeeId, long productTypeId) {
		FinderPath finderPath = _finderPathCountByEmployeeSingleRight;

		Object[] finderArgs = new Object[] {employeeId, productTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMPLOYEERIGHT_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEESINGLERIGHT_EMPLOYEEID_2);

			sb.append(_FINDER_COLUMN_EMPLOYEESINGLERIGHT_PRODUCTTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				queryPos.add(productTypeId);

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

	private static final String
		_FINDER_COLUMN_EMPLOYEESINGLERIGHT_EMPLOYEEID_2 =
			"employeeRight.employeeId = ? AND ";

	private static final String
		_FINDER_COLUMN_EMPLOYEESINGLERIGHT_PRODUCTTYPEID_2 =
			"employeeRight.productTypeId = ?";

	public EmployeeRightPersistenceImpl() {
		setModelClass(EmployeeRight.class);

		setModelImplClass(EmployeeRightImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee right in the entity cache if it is enabled.
	 *
	 * @param employeeRight the employee right
	 */
	@Override
	public void cacheResult(EmployeeRight employeeRight) {
		entityCache.putResult(
			EmployeeRightImpl.class, employeeRight.getPrimaryKey(),
			employeeRight);
	}

	/**
	 * Caches the employee rights in the entity cache if it is enabled.
	 *
	 * @param employeeRights the employee rights
	 */
	@Override
	public void cacheResult(List<EmployeeRight> employeeRights) {
		for (EmployeeRight employeeRight : employeeRights) {
			if (entityCache.getResult(
					EmployeeRightImpl.class, employeeRight.getPrimaryKey()) ==
						null) {

				cacheResult(employeeRight);
			}
		}
	}

	/**
	 * Clears the cache for all employee rights.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeRightImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee right.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeRight employeeRight) {
		entityCache.removeResult(EmployeeRightImpl.class, employeeRight);
	}

	@Override
	public void clearCache(List<EmployeeRight> employeeRights) {
		for (EmployeeRight employeeRight : employeeRights) {
			entityCache.removeResult(EmployeeRightImpl.class, employeeRight);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeRightImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee right with the primary key. Does not add the employee right to the database.
	 *
	 * @param rightId the primary key for the new employee right
	 * @return the new employee right
	 */
	@Override
	public EmployeeRight create(long rightId) {
		EmployeeRight employeeRight = new EmployeeRightImpl();

		employeeRight.setNew(true);
		employeeRight.setPrimaryKey(rightId);

		return employeeRight;
	}

	/**
	 * Removes the employee right with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rightId the primary key of the employee right
	 * @return the employee right that was removed
	 * @throws NoSuchEmployeeRightException if a employee right with the primary key could not be found
	 */
	@Override
	public EmployeeRight remove(long rightId)
		throws NoSuchEmployeeRightException {

		return remove((Serializable)rightId);
	}

	/**
	 * Removes the employee right with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee right
	 * @return the employee right that was removed
	 * @throws NoSuchEmployeeRightException if a employee right with the primary key could not be found
	 */
	@Override
	public EmployeeRight remove(Serializable primaryKey)
		throws NoSuchEmployeeRightException {

		Session session = null;

		try {
			session = openSession();

			EmployeeRight employeeRight = (EmployeeRight)session.get(
				EmployeeRightImpl.class, primaryKey);

			if (employeeRight == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeRightException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeRight);
		}
		catch (NoSuchEmployeeRightException noSuchEntityException) {
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
	protected EmployeeRight removeImpl(EmployeeRight employeeRight) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeRight)) {
				employeeRight = (EmployeeRight)session.get(
					EmployeeRightImpl.class, employeeRight.getPrimaryKeyObj());
			}

			if (employeeRight != null) {
				session.delete(employeeRight);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeRight != null) {
			clearCache(employeeRight);
		}

		return employeeRight;
	}

	@Override
	public EmployeeRight updateImpl(EmployeeRight employeeRight) {
		boolean isNew = employeeRight.isNew();

		if (!(employeeRight instanceof EmployeeRightModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeRight.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeRight);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeRight proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeRight implementation " +
					employeeRight.getClass());
		}

		EmployeeRightModelImpl employeeRightModelImpl =
			(EmployeeRightModelImpl)employeeRight;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeRight);
			}
			else {
				employeeRight = (EmployeeRight)session.merge(employeeRight);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeRightImpl.class, employeeRightModelImpl, false, true);

		if (isNew) {
			employeeRight.setNew(false);
		}

		employeeRight.resetOriginalValues();

		return employeeRight;
	}

	/**
	 * Returns the employee right with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee right
	 * @return the employee right
	 * @throws NoSuchEmployeeRightException if a employee right with the primary key could not be found
	 */
	@Override
	public EmployeeRight findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeRightException {

		EmployeeRight employeeRight = fetchByPrimaryKey(primaryKey);

		if (employeeRight == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeRightException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeRight;
	}

	/**
	 * Returns the employee right with the primary key or throws a <code>NoSuchEmployeeRightException</code> if it could not be found.
	 *
	 * @param rightId the primary key of the employee right
	 * @return the employee right
	 * @throws NoSuchEmployeeRightException if a employee right with the primary key could not be found
	 */
	@Override
	public EmployeeRight findByPrimaryKey(long rightId)
		throws NoSuchEmployeeRightException {

		return findByPrimaryKey((Serializable)rightId);
	}

	/**
	 * Returns the employee right with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rightId the primary key of the employee right
	 * @return the employee right, or <code>null</code> if a employee right with the primary key could not be found
	 */
	@Override
	public EmployeeRight fetchByPrimaryKey(long rightId) {
		return fetchByPrimaryKey((Serializable)rightId);
	}

	/**
	 * Returns all the employee rights.
	 *
	 * @return the employee rights
	 */
	@Override
	public List<EmployeeRight> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EmployeeRight> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<EmployeeRight> findAll(
		int start, int end,
		OrderByComparator<EmployeeRight> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<EmployeeRight> findAll(
		int start, int end, OrderByComparator<EmployeeRight> orderByComparator,
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

		List<EmployeeRight> list = null;

		if (useFinderCache) {
			list = (List<EmployeeRight>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEERIGHT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEERIGHT;

				sql = sql.concat(EmployeeRightModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeRight>)QueryUtil.list(
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
	 * Removes all the employee rights from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeRight employeeRight : findAll()) {
			remove(employeeRight);
		}
	}

	/**
	 * Returns the number of employee rights.
	 *
	 * @return the number of employee rights
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEERIGHT);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "rightId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEERIGHT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeRightModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee right persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new EmployeeRightModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EmployeeRight.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByEmployeeRightsList = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmployeeRightsList",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"employeeId"}, true);

		_finderPathWithoutPaginationFindByEmployeeRightsList =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByEmployeeRightsList", new String[] {Long.class.getName()},
				new String[] {"employeeId"}, true);

		_finderPathCountByEmployeeRightsList = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmployeeRightsList", new String[] {Long.class.getName()},
			new String[] {"employeeId"}, false);

		_finderPathWithPaginationFindByEmployeeSingleRight = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmployeeSingleRight",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"employeeId", "productTypeId"}, true);

		_finderPathWithoutPaginationFindByEmployeeSingleRight =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByEmployeeSingleRight",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"employeeId", "productTypeId"}, true);

		_finderPathCountByEmployeeSingleRight = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmployeeSingleRight",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"employeeId", "productTypeId"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EmployeeRightImpl.class.getName());

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

	private static final String _SQL_SELECT_EMPLOYEERIGHT =
		"SELECT employeeRight FROM EmployeeRight employeeRight";

	private static final String _SQL_SELECT_EMPLOYEERIGHT_WHERE =
		"SELECT employeeRight FROM EmployeeRight employeeRight WHERE ";

	private static final String _SQL_COUNT_EMPLOYEERIGHT =
		"SELECT COUNT(employeeRight) FROM EmployeeRight employeeRight";

	private static final String _SQL_COUNT_EMPLOYEERIGHT_WHERE =
		"SELECT COUNT(employeeRight) FROM EmployeeRight employeeRight WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeRight.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeRight exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeRight exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeRightPersistenceImpl.class);

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

	private static class EmployeeRightModelArgumentsResolver
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

			EmployeeRightModelImpl employeeRightModelImpl =
				(EmployeeRightModelImpl)baseModel;

			long columnBitmask = employeeRightModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(employeeRightModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeRightModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(employeeRightModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			EmployeeRightModelImpl employeeRightModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						employeeRightModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = employeeRightModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}