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

package com.trollingcont.servicebuilder.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.trollingcont.servicebuilder.exception.PostException;
import com.trollingcont.servicebuilder.model.Post;
import com.trollingcont.servicebuilder.service.base.PostLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the post local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.trollingcont.servicebuilder.service.PostLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.trollingcont.servicebuilder.model.Post",
	service = AopService.class
)
public class PostLocalServiceImpl extends PostLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.trollingcont.servicebuilder.service.PostLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.trollingcont.servicebuilder.service.PostLocalServiceUtil</code>.
	 */

	private final int MAX_POST_LENGTH = 100;

	public Post addPost(
			String name,
			ServiceContext serviceContext
	) throws PortalException {

		validate(name);

		long entryId = counterLocalService.increment();

		Post post = postPersistence.create(entryId);

		post.setUuid(serviceContext.getUuid());
		post.setName(name);
		post.setExpandoBridgeAttributes(serviceContext);

		postPersistence.update(post);

		return post;
	}

	public Post updatePost(
			Post post,
			ServiceContext serviceContext
	) throws PortalException {

		validate(post.getName());

		post.setExpandoBridgeAttributes(serviceContext);

		postPersistence.update(post);

		return post;
	}

	public List<Post> getAllPosts() {

		return postPersistence.findAll();
	}

	protected void validate(String name) throws PostException {

		if (name == null || name.isBlank()) {
			throw new PostException(PostException.ErrorCode.NAME_EMPTY);
		}

		if (name.length() > MAX_POST_LENGTH) {
			throw new PostException(PostException.ErrorCode.NAME_TOO_LONG);
		}
	}
}