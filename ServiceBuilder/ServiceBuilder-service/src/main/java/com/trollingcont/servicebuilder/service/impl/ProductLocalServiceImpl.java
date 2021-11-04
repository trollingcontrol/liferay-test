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
import com.trollingcont.servicebuilder.exception.ProductException;
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

	private final int MAX_PRODUCT_NAME_LENGTH = 150;
	private final int MAX_PRODUCT_DESCRIPTION_LENGTH = 5000;

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

	public Product updateProduct(
			Product product,
			ServiceContext serviceContext
	) throws PortalException {

		validate(product.getName(), product.getDescription(), product.getAmount(), product.getCost());
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

		if (name == null || name.isBlank()) {
			throw new ProductException(ProductException.ErrorCode.NAME_EMPTY);
		}

		if (name.length() > MAX_PRODUCT_NAME_LENGTH) {
			throw new ProductException(ProductException.ErrorCode.NAME_TOO_LONG);
		}

		if (description == null || description.isBlank()) {
			throw new ProductException(ProductException.ErrorCode.DESCRIPTION_EMPTY);
		}

		if (description.length() > MAX_PRODUCT_DESCRIPTION_LENGTH) {
			throw new ProductException(ProductException.ErrorCode.DESCRIPTION_TOO_LONG);
		}

		if (cost < 0) {
			throw new ProductException(ProductException.ErrorCode.INVALID_COST);
		}

		if (amount < 0) {
			throw new ProductException(ProductException.ErrorCode.INVALID_AMOUNT);
		}

	}
}