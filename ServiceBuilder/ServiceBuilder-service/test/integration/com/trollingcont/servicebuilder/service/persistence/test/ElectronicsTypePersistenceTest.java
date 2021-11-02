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

import com.trollingcont.servicebuilder.exception.NoSuchElectronicsTypeException;
import com.trollingcont.servicebuilder.model.ElectronicsType;
import com.trollingcont.servicebuilder.service.ElectronicsTypeLocalServiceUtil;
import com.trollingcont.servicebuilder.service.persistence.ElectronicsTypePersistence;
import com.trollingcont.servicebuilder.service.persistence.ElectronicsTypeUtil;

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
public class ElectronicsTypePersistenceTest {

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
		_persistence = ElectronicsTypeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ElectronicsType> iterator = _electronicsTypes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ElectronicsType electronicsType = _persistence.create(pk);

		Assert.assertNotNull(electronicsType);

		Assert.assertEquals(electronicsType.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ElectronicsType newElectronicsType = addElectronicsType();

		_persistence.remove(newElectronicsType);

		ElectronicsType existingElectronicsType =
			_persistence.fetchByPrimaryKey(newElectronicsType.getPrimaryKey());

		Assert.assertNull(existingElectronicsType);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addElectronicsType();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ElectronicsType newElectronicsType = _persistence.create(pk);

		newElectronicsType.setUuid(RandomTestUtil.randomString());

		newElectronicsType.setName(RandomTestUtil.randomString());

		_electronicsTypes.add(_persistence.update(newElectronicsType));

		ElectronicsType existingElectronicsType = _persistence.findByPrimaryKey(
			newElectronicsType.getPrimaryKey());

		Assert.assertEquals(
			existingElectronicsType.getUuid(), newElectronicsType.getUuid());
		Assert.assertEquals(
			existingElectronicsType.getProductTypeId(),
			newElectronicsType.getProductTypeId());
		Assert.assertEquals(
			existingElectronicsType.getName(), newElectronicsType.getName());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ElectronicsType newElectronicsType = addElectronicsType();

		ElectronicsType existingElectronicsType = _persistence.findByPrimaryKey(
			newElectronicsType.getPrimaryKey());

		Assert.assertEquals(existingElectronicsType, newElectronicsType);
	}

	@Test(expected = NoSuchElectronicsTypeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ElectronicsType> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"LS_ElectronicsType", "uuid", true, "productTypeId", true, "name",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ElectronicsType newElectronicsType = addElectronicsType();

		ElectronicsType existingElectronicsType =
			_persistence.fetchByPrimaryKey(newElectronicsType.getPrimaryKey());

		Assert.assertEquals(existingElectronicsType, newElectronicsType);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ElectronicsType missingElectronicsType = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingElectronicsType);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ElectronicsType newElectronicsType1 = addElectronicsType();
		ElectronicsType newElectronicsType2 = addElectronicsType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectronicsType1.getPrimaryKey());
		primaryKeys.add(newElectronicsType2.getPrimaryKey());

		Map<Serializable, ElectronicsType> electronicsTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, electronicsTypes.size());
		Assert.assertEquals(
			newElectronicsType1,
			electronicsTypes.get(newElectronicsType1.getPrimaryKey()));
		Assert.assertEquals(
			newElectronicsType2,
			electronicsTypes.get(newElectronicsType2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ElectronicsType> electronicsTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(electronicsTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ElectronicsType newElectronicsType = addElectronicsType();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectronicsType.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ElectronicsType> electronicsTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, electronicsTypes.size());
		Assert.assertEquals(
			newElectronicsType,
			electronicsTypes.get(newElectronicsType.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ElectronicsType> electronicsTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(electronicsTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ElectronicsType newElectronicsType = addElectronicsType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectronicsType.getPrimaryKey());

		Map<Serializable, ElectronicsType> electronicsTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, electronicsTypes.size());
		Assert.assertEquals(
			newElectronicsType,
			electronicsTypes.get(newElectronicsType.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ElectronicsTypeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ElectronicsType>() {

				@Override
				public void performAction(ElectronicsType electronicsType) {
					Assert.assertNotNull(electronicsType);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ElectronicsType newElectronicsType = addElectronicsType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ElectronicsType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"productTypeId", newElectronicsType.getProductTypeId()));

		List<ElectronicsType> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ElectronicsType existingElectronicsType = result.get(0);

		Assert.assertEquals(existingElectronicsType, newElectronicsType);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ElectronicsType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"productTypeId", RandomTestUtil.nextLong()));

		List<ElectronicsType> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ElectronicsType newElectronicsType = addElectronicsType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ElectronicsType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("productTypeId"));

		Object newProductTypeId = newElectronicsType.getProductTypeId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"productTypeId", new Object[] {newProductTypeId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingProductTypeId = result.get(0);

		Assert.assertEquals(existingProductTypeId, newProductTypeId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ElectronicsType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("productTypeId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"productTypeId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ElectronicsType addElectronicsType() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ElectronicsType electronicsType = _persistence.create(pk);

		electronicsType.setUuid(RandomTestUtil.randomString());

		electronicsType.setName(RandomTestUtil.randomString());

		_electronicsTypes.add(_persistence.update(electronicsType));

		return electronicsType;
	}

	private List<ElectronicsType> _electronicsTypes =
		new ArrayList<ElectronicsType>();
	private ElectronicsTypePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}