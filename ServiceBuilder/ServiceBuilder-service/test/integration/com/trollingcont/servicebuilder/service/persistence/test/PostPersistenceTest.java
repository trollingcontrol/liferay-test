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

import com.trollingcont.servicebuilder.exception.NoSuchPostException;
import com.trollingcont.servicebuilder.model.Post;
import com.trollingcont.servicebuilder.service.PostLocalServiceUtil;
import com.trollingcont.servicebuilder.service.persistence.PostPersistence;
import com.trollingcont.servicebuilder.service.persistence.PostUtil;

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
public class PostPersistenceTest {

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
		_persistence = PostUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Post> iterator = _posts.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Post post = _persistence.create(pk);

		Assert.assertNotNull(post);

		Assert.assertEquals(post.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Post newPost = addPost();

		_persistence.remove(newPost);

		Post existingPost = _persistence.fetchByPrimaryKey(
			newPost.getPrimaryKey());

		Assert.assertNull(existingPost);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPost();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Post newPost = _persistence.create(pk);

		newPost.setUuid(RandomTestUtil.randomString());

		newPost.setName(RandomTestUtil.randomString());

		_posts.add(_persistence.update(newPost));

		Post existingPost = _persistence.findByPrimaryKey(
			newPost.getPrimaryKey());

		Assert.assertEquals(existingPost.getUuid(), newPost.getUuid());
		Assert.assertEquals(existingPost.getPostId(), newPost.getPostId());
		Assert.assertEquals(existingPost.getName(), newPost.getName());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Post newPost = addPost();

		Post existingPost = _persistence.findByPrimaryKey(
			newPost.getPrimaryKey());

		Assert.assertEquals(existingPost, newPost);
	}

	@Test(expected = NoSuchPostException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Post> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"LS_Post", "uuid", true, "postId", true, "name", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Post newPost = addPost();

		Post existingPost = _persistence.fetchByPrimaryKey(
			newPost.getPrimaryKey());

		Assert.assertEquals(existingPost, newPost);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Post missingPost = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPost);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Post newPost1 = addPost();
		Post newPost2 = addPost();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPost1.getPrimaryKey());
		primaryKeys.add(newPost2.getPrimaryKey());

		Map<Serializable, Post> posts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, posts.size());
		Assert.assertEquals(newPost1, posts.get(newPost1.getPrimaryKey()));
		Assert.assertEquals(newPost2, posts.get(newPost2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Post> posts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(posts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Post newPost = addPost();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPost.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Post> posts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, posts.size());
		Assert.assertEquals(newPost, posts.get(newPost.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Post> posts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(posts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Post newPost = addPost();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPost.getPrimaryKey());

		Map<Serializable, Post> posts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, posts.size());
		Assert.assertEquals(newPost, posts.get(newPost.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PostLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Post>() {

				@Override
				public void performAction(Post post) {
					Assert.assertNotNull(post);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Post newPost = addPost();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Post.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("postId", newPost.getPostId()));

		List<Post> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Post existingPost = result.get(0);

		Assert.assertEquals(existingPost, newPost);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Post.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("postId", RandomTestUtil.nextLong()));

		List<Post> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Post newPost = addPost();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Post.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("postId"));

		Object newPostId = newPost.getPostId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("postId", new Object[] {newPostId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingPostId = result.get(0);

		Assert.assertEquals(existingPostId, newPostId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Post.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("postId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"postId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Post addPost() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Post post = _persistence.create(pk);

		post.setUuid(RandomTestUtil.randomString());

		post.setName(RandomTestUtil.randomString());

		_posts.add(_persistence.update(post));

		return post;
	}

	private List<Post> _posts = new ArrayList<Post>();
	private PostPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}