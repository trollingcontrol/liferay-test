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

import com.trollingcont.servicebuilder.exception.NoSuchProductTypeException;
import com.trollingcont.servicebuilder.model.ProductType;
import com.trollingcont.servicebuilder.service.ProductTypeLocalServiceUtil;
import com.trollingcont.servicebuilder.service.persistence.ProductTypePersistence;
import com.trollingcont.servicebuilder.service.persistence.ProductTypeUtil;

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
public class ProductTypePersistenceTest {

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
		_persistence = ProductTypeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ProductType> iterator = _productTypes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ProductType productType = _persistence.create(pk);

		Assert.assertNotNull(productType);

		Assert.assertEquals(productType.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ProductType newProductType = addProductType();

		_persistence.remove(newProductType);

		ProductType existingProductType = _persistence.fetchByPrimaryKey(
			newProductType.getPrimaryKey());

		Assert.assertNull(existingProductType);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addProductType();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ProductType newProductType = _persistence.create(pk);

		newProductType.setUuid(RandomTestUtil.randomString());

		newProductType.setName(RandomTestUtil.randomString());

		_productTypes.add(_persistence.update(newProductType));

		ProductType existingProductType = _persistence.findByPrimaryKey(
			newProductType.getPrimaryKey());

		Assert.assertEquals(
			existingProductType.getUuid(), newProductType.getUuid());
		Assert.assertEquals(
			existingProductType.getProductTypeId(),
			newProductType.getProductTypeId());
		Assert.assertEquals(
			existingProductType.getName(), newProductType.getName());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ProductType newProductType = addProductType();

		ProductType existingProductType = _persistence.findByPrimaryKey(
			newProductType.getPrimaryKey());

		Assert.assertEquals(existingProductType, newProductType);
	}

	@Test(expected = NoSuchProductTypeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ProductType> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"LS_ProductType", "uuid", true, "productTypeId", true, "name",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ProductType newProductType = addProductType();

		ProductType existingProductType = _persistence.fetchByPrimaryKey(
			newProductType.getPrimaryKey());

		Assert.assertEquals(existingProductType, newProductType);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ProductType missingProductType = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingProductType);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ProductType newProductType1 = addProductType();
		ProductType newProductType2 = addProductType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProductType1.getPrimaryKey());
		primaryKeys.add(newProductType2.getPrimaryKey());

		Map<Serializable, ProductType> productTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, productTypes.size());
		Assert.assertEquals(
			newProductType1, productTypes.get(newProductType1.getPrimaryKey()));
		Assert.assertEquals(
			newProductType2, productTypes.get(newProductType2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ProductType> productTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(productTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ProductType newProductType = addProductType();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProductType.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ProductType> productTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, productTypes.size());
		Assert.assertEquals(
			newProductType, productTypes.get(newProductType.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ProductType> productTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(productTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ProductType newProductType = addProductType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProductType.getPrimaryKey());

		Map<Serializable, ProductType> productTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, productTypes.size());
		Assert.assertEquals(
			newProductType, productTypes.get(newProductType.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ProductTypeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ProductType>() {

				@Override
				public void performAction(ProductType productType) {
					Assert.assertNotNull(productType);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ProductType newProductType = addProductType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ProductType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"productTypeId", newProductType.getProductTypeId()));

		List<ProductType> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ProductType existingProductType = result.get(0);

		Assert.assertEquals(existingProductType, newProductType);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ProductType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"productTypeId", RandomTestUtil.nextLong()));

		List<ProductType> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ProductType newProductType = addProductType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ProductType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("productTypeId"));

		Object newProductTypeId = newProductType.getProductTypeId();

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
			ProductType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("productTypeId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"productTypeId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ProductType addProductType() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ProductType productType = _persistence.create(pk);

		productType.setUuid(RandomTestUtil.randomString());

		productType.setName(RandomTestUtil.randomString());

		_productTypes.add(_persistence.update(productType));

		return productType;
	}

	private List<ProductType> _productTypes = new ArrayList<ProductType>();
	private ProductTypePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}