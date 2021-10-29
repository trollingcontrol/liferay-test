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

import com.trollingcont.servicebuilder.exception.NoSuchPostException;
import com.trollingcont.servicebuilder.model.Post;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the post service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostUtil
 * @generated
 */
@ProviderType
public interface PostPersistence extends BasePersistence<Post> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PostUtil} to access the post persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the posts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching posts
	 */
	public java.util.List<Post> findByUuid(String uuid);

	/**
	 * Returns a range of all the posts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of posts
	 * @param end the upper bound of the range of posts (not inclusive)
	 * @return the range of matching posts
	 */
	public java.util.List<Post> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the posts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of posts
	 * @param end the upper bound of the range of posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching posts
	 */
	public java.util.List<Post> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Post>
			orderByComparator);

	/**
	 * Returns an ordered range of all the posts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of posts
	 * @param end the upper bound of the range of posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching posts
	 */
	public java.util.List<Post> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Post>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post
	 * @throws NoSuchPostException if a matching post could not be found
	 */
	public Post findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Post>
				orderByComparator)
		throws NoSuchPostException;

	/**
	 * Returns the first post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post, or <code>null</code> if a matching post could not be found
	 */
	public Post fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Post>
			orderByComparator);

	/**
	 * Returns the last post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post
	 * @throws NoSuchPostException if a matching post could not be found
	 */
	public Post findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Post>
				orderByComparator)
		throws NoSuchPostException;

	/**
	 * Returns the last post in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post, or <code>null</code> if a matching post could not be found
	 */
	public Post fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Post>
			orderByComparator);

	/**
	 * Returns the posts before and after the current post in the ordered set where uuid = &#63;.
	 *
	 * @param postId the primary key of the current post
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next post
	 * @throws NoSuchPostException if a post with the primary key could not be found
	 */
	public Post[] findByUuid_PrevAndNext(
			long postId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Post>
				orderByComparator)
		throws NoSuchPostException;

	/**
	 * Removes all the posts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of posts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching posts
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the post in the entity cache if it is enabled.
	 *
	 * @param post the post
	 */
	public void cacheResult(Post post);

	/**
	 * Caches the posts in the entity cache if it is enabled.
	 *
	 * @param posts the posts
	 */
	public void cacheResult(java.util.List<Post> posts);

	/**
	 * Creates a new post with the primary key. Does not add the post to the database.
	 *
	 * @param postId the primary key for the new post
	 * @return the new post
	 */
	public Post create(long postId);

	/**
	 * Removes the post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postId the primary key of the post
	 * @return the post that was removed
	 * @throws NoSuchPostException if a post with the primary key could not be found
	 */
	public Post remove(long postId) throws NoSuchPostException;

	public Post updateImpl(Post post);

	/**
	 * Returns the post with the primary key or throws a <code>NoSuchPostException</code> if it could not be found.
	 *
	 * @param postId the primary key of the post
	 * @return the post
	 * @throws NoSuchPostException if a post with the primary key could not be found
	 */
	public Post findByPrimaryKey(long postId) throws NoSuchPostException;

	/**
	 * Returns the post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postId the primary key of the post
	 * @return the post, or <code>null</code> if a post with the primary key could not be found
	 */
	public Post fetchByPrimaryKey(long postId);

	/**
	 * Returns all the posts.
	 *
	 * @return the posts
	 */
	public java.util.List<Post> findAll();

	/**
	 * Returns a range of all the posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of posts
	 * @param end the upper bound of the range of posts (not inclusive)
	 * @return the range of posts
	 */
	public java.util.List<Post> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of posts
	 * @param end the upper bound of the range of posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of posts
	 */
	public java.util.List<Post> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Post>
			orderByComparator);

	/**
	 * Returns an ordered range of all the posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of posts
	 * @param end the upper bound of the range of posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of posts
	 */
	public java.util.List<Post> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Post>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the posts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of posts.
	 *
	 * @return the number of posts
	 */
	public int countAll();

}