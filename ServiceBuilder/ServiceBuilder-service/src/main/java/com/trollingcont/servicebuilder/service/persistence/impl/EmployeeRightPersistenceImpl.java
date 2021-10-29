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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.trollingcont.servicebuilder.exception.NoSuchEmployeeRightException;
import com.trollingcont.servicebuilder.model.EmployeeRight;
import com.trollingcont.servicebuilder.model.impl.EmployeeRightImpl;
import com.trollingcont.servicebuilder.model.impl.EmployeeRightModelImpl;
import com.trollingcont.servicebuilder.service.persistence.EmployeeRightPersistence;
import com.trollingcont.servicebuilder.service.persistence.impl.constants.LSPersistenceConstants;

import java.io.Serializable;

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
			EmployeeRightImpl.class, employeeRight, false, true);

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

	private static final String _SQL_COUNT_EMPLOYEERIGHT =
		"SELECT COUNT(employeeRight) FROM EmployeeRight employeeRight";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeRight.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeRight exists with the primary key ";

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