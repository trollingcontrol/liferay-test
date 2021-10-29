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

package com.trollingcont.servicebuilder.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Post}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Post
 * @generated
 */
public class PostWrapper
	extends BaseModelWrapper<Post> implements ModelWrapper<Post>, Post {

	public PostWrapper(Post post) {
		super(post);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("postId", getPostId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long postId = (Long)attributes.get("postId");

		if (postId != null) {
			setPostId(postId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	 * Returns the name of this post.
	 *
	 * @return the name of this post
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the post ID of this post.
	 *
	 * @return the post ID of this post
	 */
	@Override
	public long getPostId() {
		return model.getPostId();
	}

	/**
	 * Returns the primary key of this post.
	 *
	 * @return the primary key of this post
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this post.
	 *
	 * @return the uuid of this post
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the name of this post.
	 *
	 * @param name the name of this post
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the post ID of this post.
	 *
	 * @param postId the post ID of this post
	 */
	@Override
	public void setPostId(long postId) {
		model.setPostId(postId);
	}

	/**
	 * Sets the primary key of this post.
	 *
	 * @param primaryKey the primary key of this post
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this post.
	 *
	 * @param uuid the uuid of this post
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected PostWrapper wrap(Post post) {
		return new PostWrapper(post);
	}

}