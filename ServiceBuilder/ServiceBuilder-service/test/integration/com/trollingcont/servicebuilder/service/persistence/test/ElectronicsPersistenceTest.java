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

import com.trollingcont.servicebuilder.exception.NoSuchElectronicsException;
import com.trollingcont.servicebuilder.model.Electronics;
import com.trollingcont.servicebuilder.service.ElectronicsLocalServiceUtil;
import com.trollingcont.servicebuilder.service.persistence.ElectronicsPersistence;
import com.trollingcont.servicebuilder.service.persistence.ElectronicsUtil;

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
public class ElectronicsPersistenceTest {

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
		_persistence = ElectronicsUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Electronics> iterator = _electronicses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Electronics electronics = _persistence.create(pk);

		Assert.assertNotNull(electronics);

		Assert.assertEquals(electronics.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Electronics newElectronics = addElectronics();

		_persistence.remove(newElectronics);

		Electronics existingElectronics = _persistence.fetchByPrimaryKey(
			newElectronics.getPrimaryKey());

		Assert.assertNull(existingElectronics);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addElectronics();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Electronics newElectronics = _persistence.create(pk);

		newElectronics.setUuid(RandomTestUtil.randomString());

		newElectronics.setName(RandomTestUtil.randomString());

		newElectronics.setProductTypeId(RandomTestUtil.nextLong());

		newElectronics.setCost(RandomTestUtil.nextLong());

		newElectronics.setAmount(RandomTestUtil.nextLong());

		newElectronics.setPresent();

		newElectronics.setArchived();

		newElectronics.setDescription(RandomTestUtil.randomString());

		_electronicses.add(_persistence.update(newElectronics));

		Electronics existingElectronics = _persistence.findByPrimaryKey(
			newElectronics.getPrimaryKey());

		Assert.assertEquals(
			existingElectronics.getUuid(), newElectronics.getUuid());
		Assert.assertEquals(
			existingElectronics.getProductId(), newElectronics.getProductId());
		Assert.assertEquals(
			existingElectronics.getName(), newElectronics.getName());
		Assert.assertEquals(
			existingElectronics.getProductTypeId(),
			newElectronics.getProductTypeId());
		Assert.assertEquals(
			existingElectronics.getCost(), newElectronics.getCost());
		Assert.assertEquals(
			existingElectronics.getAmount(), newElectronics.getAmount());
		Assert.assertEquals(
			existingElectronics.getPresent(), newElectronics.getPresent());
		Assert.assertEquals(
			existingElectronics.getArchived(), newElectronics.getArchived());
		Assert.assertEquals(
			existingElectronics.getDescription(),
			newElectronics.getDescription());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Electronics newElectronics = addElectronics();

		Electronics existingElectronics = _persistence.findByPrimaryKey(
			newElectronics.getPrimaryKey());

		Assert.assertEquals(existingElectronics, newElectronics);
	}

	@Test(expected = NoSuchElectronicsException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Electronics> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"LS_Electronics", "uuid", true, "productId", true, "name", true,
			"productTypeId", true, "cost", true, "amount", true, "present",
			true, "archived", true, "description", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Electronics newElectronics = addElectronics();

		Electronics existingElectronics = _persistence.fetchByPrimaryKey(
			newElectronics.getPrimaryKey());

		Assert.assertEquals(existingElectronics, newElectronics);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Electronics missingElectronics = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingElectronics);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Electronics newElectronics1 = addElectronics();
		Electronics newElectronics2 = addElectronics();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectronics1.getPrimaryKey());
		primaryKeys.add(newElectronics2.getPrimaryKey());

		Map<Serializable, Electronics> electronicses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, electronicses.size());
		Assert.assertEquals(
			newElectronics1,
			electronicses.get(newElectronics1.getPrimaryKey()));
		Assert.assertEquals(
			newElectronics2,
			electronicses.get(newElectronics2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Electronics> electronicses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(electronicses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Electronics newElectronics = addElectronics();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectronics.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Electronics> electronicses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, electronicses.size());
		Assert.assertEquals(
			newElectronics, electronicses.get(newElectronics.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Electronics> electronicses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(electronicses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Electronics newElectronics = addElectronics();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectronics.getPrimaryKey());

		Map<Serializable, Electronics> electronicses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, electronicses.size());
		Assert.assertEquals(
			newElectronics, electronicses.get(newElectronics.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ElectronicsLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Electronics>() {

				@Override
				public void performAction(Electronics electronics) {
					Assert.assertNotNull(electronics);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Electronics newElectronics = addElectronics();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electronics.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"productId", newElectronics.getProductId()));

		List<Electronics> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Electronics existingElectronics = result.get(0);

		Assert.assertEquals(existingElectronics, newElectronics);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electronics.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("productId", RandomTestUtil.nextLong()));

		List<Electronics> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Electronics newElectronics = addElectronics();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electronics.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("productId"));

		Object newProductId = newElectronics.getProductId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"productId", new Object[] {newProductId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingProductId = result.get(0);

		Assert.assertEquals(existingProductId, newProductId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electronics.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("productId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"productId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Electronics addElectronics() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Electronics electronics = _persistence.create(pk);

		electronics.setUuid(RandomTestUtil.randomString());

		electronics.setName(RandomTestUtil.randomString());

		electronics.setProductTypeId(RandomTestUtil.nextLong());

		electronics.setCost(RandomTestUtil.nextLong());

		electronics.setAmount(RandomTestUtil.nextLong());

		electronics.setPresent();

		electronics.setArchived();

		electronics.setDescription(RandomTestUtil.randomString());

		_electronicses.add(_persistence.update(electronics));

		return electronics;
	}

	private List<Electronics> _electronicses = new ArrayList<Electronics>();
	private ElectronicsPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}