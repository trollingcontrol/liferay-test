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
import com.trollingcont.servicebuilder.model.Product;
import com.trollingcont.servicebuilder.service.base.ProductLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the product local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.trollingcont.servicebuilder.service.ProductLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.trollingcont.servicebuilder.model.Product",
	service = AopService.class
)
public class ProductLocalServiceImpl extends ProductLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.trollingcont.servicebuilder.service.ProductLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.trollingcont.servicebuilder.service.ProductLocalServiceUtil</code>.
	 */

	public Product addProduct(
			String name,
			long productTypeId, // LINK
			long cost,
			long amount,
			boolean present,
			boolean archived,
			String description,
			ServiceContext serviceContext
	) throws PortalException {

		validate(name, description, amount, cost);

		long entryId = counterLocalService.increment();

		Product product = productPersistence.create(entryId);

		product.setUuid(serviceContext.getUuid());
		product.setName(name);
		product.setProductTypeId(productTypeId);
		product.setCost(cost);
		product.setAmount(amount);
		product.setPresent(present);
		product.setArchived(archived);
		product.setDescription(description);
		product.setExpandoBridgeAttributes(serviceContext);

		productPersistence.update(product);

		return product;
	}

	public Product updateElectronics(
			long productId,
			String name,
			long productTypeId, // LINK
			long cost,
			long amount,
			boolean present,
			boolean archived,
			String description,
			ServiceContext serviceContext
	) throws PortalException {

		validate(name, description, amount, cost);

		Product product = productPersistence.findByPrimaryKey(productId);

		product.setName(name);
		product.setProductTypeId(productTypeId);
		product.setCost(cost);
		product.setAmount(amount);
		product.setPresent(present);
		product.setArchived(archived);
		product.setDescription(description);
		product.setExpandoBridgeAttributes(serviceContext);

		productPersistence.update(product);

		return product;
	}

	protected void validate(
			String name,
			String description,
			long amount,
			long cost
	) throws PortalException {

		if (name == null || name.isEmpty()) {
			throw new PortalException("Name is null or empty");
		}

		if (description == null || description.isEmpty()) {
			throw new PortalException("Descrption is null or empty");
		}

		if (cost < 0) {
			throw new PortalException("Cost is less then 0");
		}

		if (amount < 0) {
			throw new PortalException("Amount is less then 0");
		}

	}
}