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

import com.trollingcont.servicebuilder.exception.NoSuchProductException;
import com.trollingcont.servicebuilder.model.Product;
import com.trollingcont.servicebuilder.service.ProductLocalServiceUtil;
import com.trollingcont.servicebuilder.service.persistence.ProductPersistence;
import com.trollingcont.servicebuilder.service.persistence.ProductUtil;

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
public class ProductPersistenceTest {

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
		_persistence = ProductUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Product> iterator = _products.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Product product = _persistence.create(pk);

		Assert.assertNotNull(product);

		Assert.assertEquals(product.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Product newProduct = addProduct();

		_persistence.remove(newProduct);

		Product existingProduct = _persistence.fetchByPrimaryKey(
			newProduct.getPrimaryKey());

		Assert.assertNull(existingProduct);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addProduct();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Product newProduct = _persistence.create(pk);

		newProduct.setUuid(RandomTestUtil.randomString());

		newProduct.setName(RandomTestUtil.randomString());

		newProduct.setProductTypeId(RandomTestUtil.nextLong());

		newProduct.setCost(RandomTestUtil.nextLong());

		newProduct.setAmount(RandomTestUtil.nextLong());

		newProduct.setPresent();

		newProduct.setArchived();

		newProduct.setDescription(RandomTestUtil.randomString());

		_products.add(_persistence.update(newProduct));

		Product existingProduct = _persistence.findByPrimaryKey(
			newProduct.getPrimaryKey());

		Assert.assertEquals(existingProduct.getUuid(), newProduct.getUuid());
		Assert.assertEquals(
			existingProduct.getProductId(), newProduct.getProductId());
		Assert.assertEquals(existingProduct.getName(), newProduct.getName());
		Assert.assertEquals(
			existingProduct.getProductTypeId(), newProduct.getProductTypeId());
		Assert.assertEquals(existingProduct.getCost(), newProduct.getCost());
		Assert.assertEquals(
			existingProduct.getAmount(), newProduct.getAmount());
		Assert.assertEquals(
			existingProduct.getPresent(), newProduct.getPresent());
		Assert.assertEquals(
			existingProduct.getArchived(), newProduct.getArchived());
		Assert.assertEquals(
			existingProduct.getDescription(), newProduct.getDescription());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Product newProduct = addProduct();

		Product existingProduct = _persistence.findByPrimaryKey(
			newProduct.getPrimaryKey());

		Assert.assertEquals(existingProduct, newProduct);
	}

	@Test(expected = NoSuchProductException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Product> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"LS_Product", "uuid", true, "productId", true, "name", true,
			"productTypeId", true, "cost", true, "amount", true, "present",
			true, "archived", true, "description", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Product newProduct = addProduct();

		Product existingProduct = _persistence.fetchByPrimaryKey(
			newProduct.getPrimaryKey());

		Assert.assertEquals(existingProduct, newProduct);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Product missingProduct = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingProduct);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Product newProduct1 = addProduct();
		Product newProduct2 = addProduct();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProduct1.getPrimaryKey());
		primaryKeys.add(newProduct2.getPrimaryKey());

		Map<Serializable, Product> products = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, products.size());
		Assert.assertEquals(
			newProduct1, products.get(newProduct1.getPrimaryKey()));
		Assert.assertEquals(
			newProduct2, products.get(newProduct2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Product> products = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(products.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Product newProduct = addProduct();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProduct.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Product> products = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, products.size());
		Assert.assertEquals(
			newProduct, products.get(newProduct.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Product> products = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(products.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Product newProduct = addProduct();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProduct.getPrimaryKey());

		Map<Serializable, Product> products = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, products.size());
		Assert.assertEquals(
			newProduct, products.get(newProduct.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ProductLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Product>() {

				@Override
				public void performAction(Product product) {
					Assert.assertNotNull(product);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Product newProduct = addProduct();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Product.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("productId", newProduct.getProductId()));

		List<Product> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Product existingProduct = result.get(0);

		Assert.assertEquals(existingProduct, newProduct);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Product.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("productId", RandomTestUtil.nextLong()));

		List<Product> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Product newProduct = addProduct();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Product.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("productId"));

		Object newProductId = newProduct.getProductId();

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
			Product.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("productId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"productId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Product addProduct() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Product product = _persistence.create(pk);

		product.setUuid(RandomTestUtil.randomString());

		product.setName(RandomTestUtil.randomString());

		product.setProductTypeId(RandomTestUtil.nextLong());

		product.setCost(RandomTestUtil.nextLong());

		product.setAmount(RandomTestUtil.nextLong());

		product.setPresent();

		product.setArchived();

		product.setDescription(RandomTestUtil.randomString());

		_products.add(_persistence.update(product));

		return product;
	}

	private List<Product> _products = new ArrayList<Product>();
	private ProductPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}