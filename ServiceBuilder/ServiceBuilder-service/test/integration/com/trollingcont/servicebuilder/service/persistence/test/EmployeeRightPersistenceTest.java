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

package com.trollingcont.servicebuilder.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.trollingcont.servicebuilder.exception.NoSuchEmployeeRightException;
import com.trollingcont.servicebuilder.model.EmployeeRight;
import com.trollingcont.servicebuilder.service.EmployeeRightLocalServiceUtil;
import com.trollingcont.servicebuilder.service.persistence.EmployeeRightPersistence;
import com.trollingcont.servicebuilder.service.persistence.EmployeeRightUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class EmployeeRightPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED,
				"com.trollingcont.servicebuilder.service"));

	@Before
	public void setUp() {
		_persistence = EmployeeRightUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EmployeeRight> iterator = _employeeRights.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmployeeRight employeeRight = _persistence.create(pk);

		Assert.assertNotNull(employeeRight);

		Assert.assertEquals(employeeRight.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EmployeeRight newEmployeeRight = addEmployeeRight();

		_persistence.remove(newEmployeeRight);

		EmployeeRight existingEmployeeRight = _persistence.fetchByPrimaryKey(
			newEmployeeRight.getPrimaryKey());

		Assert.assertNull(existingEmployeeRight);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEmployeeRight();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmployeeRight newEmployeeRight = _persistence.create(pk);

		newEmployeeRight.setEmployeeId(RandomTestUtil.nextLong());

		newEmployeeRight.setProductTypeId(RandomTestUtil.nextLong());

		_employeeRights.add(_persistence.update(newEmployeeRight));

		EmployeeRight existingEmployeeRight = _persistence.findByPrimaryKey(
			newEmployeeRight.getPrimaryKey());

		Assert.assertEquals(
			existingEmployeeRight.getRightId(), newEmployeeRight.getRightId());
		Assert.assertEquals(
			existingEmployeeRight.getEmployeeId(),
			newEmployeeRight.getEmployeeId());
		Assert.assertEquals(
			existingEmployeeRight.getProductTypeId(),
			newEmployeeRight.getProductTypeId());
	}

	@Test
	public void testCountByEmployeeRightsList() throws Exception {
		_persistence.countByEmployeeRightsList(RandomTestUtil.nextLong());

		_persistence.countByEmployeeRightsList(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EmployeeRight newEmployeeRight = addEmployeeRight();

		EmployeeRight existingEmployeeRight = _persistence.findByPrimaryKey(
			newEmployeeRight.getPrimaryKey());

		Assert.assertEquals(existingEmployeeRight, newEmployeeRight);
	}

	@Test(expected = NoSuchEmployeeRightException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<EmployeeRight> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"LS_EmployeeRight", "rightId", true, "employeeId", true,
			"productTypeId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EmployeeRight newEmployeeRight = addEmployeeRight();

		EmployeeRight existingEmployeeRight = _persistence.fetchByPrimaryKey(
			newEmployeeRight.getPrimaryKey());

		Assert.assertEquals(existingEmployeeRight, newEmployeeRight);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmployeeRight missingEmployeeRight = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEmployeeRight);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EmployeeRight newEmployeeRight1 = addEmployeeRight();
		EmployeeRight newEmployeeRight2 = addEmployeeRight();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployeeRight1.getPrimaryKey());
		primaryKeys.add(newEmployeeRight2.getPrimaryKey());

		Map<Serializable, EmployeeRight> employeeRights =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, employeeRights.size());
		Assert.assertEquals(
			newEmployeeRight1,
			employeeRights.get(newEmployeeRight1.getPrimaryKey()));
		Assert.assertEquals(
			newEmployeeRight2,
			employeeRights.get(newEmployeeRight2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EmployeeRight> employeeRights =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(employeeRights.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EmployeeRight newEmployeeRight = addEmployeeRight();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployeeRight.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EmployeeRight> employeeRights =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, employeeRights.size());
		Assert.assertEquals(
			newEmployeeRight,
			employeeRights.get(newEmployeeRight.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EmployeeRight> employeeRights =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(employeeRights.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EmployeeRight newEmployeeRight = addEmployeeRight();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployeeRight.getPrimaryKey());

		Map<Serializable, EmployeeRight> employeeRights =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, employeeRights.size());
		Assert.assertEquals(
			newEmployeeRight,
			employeeRights.get(newEmployeeRight.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EmployeeRightLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<EmployeeRight>() {

				@Override
				public void performAction(EmployeeRight employeeRight) {
					Assert.assertNotNull(employeeRight);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EmployeeRight newEmployeeRight = addEmployeeRight();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeRight.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"rightId", newEmployeeRight.getRightId()));

		List<EmployeeRight> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		EmployeeRight existingEmployeeRight = result.get(0);

		Assert.assertEquals(existingEmployeeRight, newEmployeeRight);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeRight.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("rightId", RandomTestUtil.nextLong()));

		List<EmployeeRight> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EmployeeRight newEmployeeRight = addEmployeeRight();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeRight.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("rightId"));

		Object newRightId = newEmployeeRight.getRightId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("rightId", new Object[] {newRightId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingRightId = result.get(0);

		Assert.assertEquals(existingRightId, newRightId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmployeeRight.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("rightId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"rightId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected EmployeeRight addEmployeeRight() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmployeeRight employeeRight = _persistence.create(pk);

		employeeRight.setEmployeeId(RandomTestUtil.nextLong());

		employeeRight.setProductTypeId(RandomTestUtil.nextLong());

		_employeeRights.add(_persistence.update(employeeRight));

		return employeeRight;
	}

	private List<EmployeeRight> _employeeRights =
		new ArrayList<EmployeeRight>();
	private EmployeeRightPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}