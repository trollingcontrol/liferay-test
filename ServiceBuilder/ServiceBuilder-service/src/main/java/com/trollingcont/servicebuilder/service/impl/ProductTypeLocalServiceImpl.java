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
import com.trollingcont.servicebuilder.exception.ProductTypeNameException;
import com.trollingcont.servicebuilder.model.ProductType;
import com.trollingcont.servicebuilder.service.base.ProductTypeLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the product type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.trollingcont.servicebuilder.service.ProductTypeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductTypeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.trollingcont.servicebuilder.model.ProductType",
	service = AopService.class
)
public class ProductTypeLocalServiceImpl
	extends ProductTypeLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.trollingcont.servicebuilder.service.ProductTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.trollingcont.servicebuilder.service.ProductTypeLocalServiceUtil</code>.
	 */

	private final int MAX_PRODUCT_NAME_TYPE_LENGTH = 100;

	public ProductType addProductType(
			String name,
			ServiceContext serviceContext
	) throws PortalException {

		validate(name);

		long entryId = counterLocalService.increment();

		ProductType productType = productTypePersistence.create(entryId);

		productType.setUuid(serviceContext.getUuid());
		productType.setName(name);
		productType.setExpandoBridgeAttributes(serviceContext);

		productTypePersistence.update(productType);

		return productType;
	}

	public ProductType updateProductType(
			long productTypeId,
			String name,
			ServiceContext serviceContext
	) throws PortalException {

		validate(name);

		ProductType productType = productTypePersistence.findByPrimaryKey(productTypeId);

		productType.setName(name);
		productType.setExpandoBridgeAttributes(serviceContext);

		productTypePersistence.update(productType);

		return productType;
	}

	protected void validate(String name)
			throws PortalException {

		if (name == null || name.isBlank()) {
			throw new ProductTypeNameException(
					ProductTypeNameException.ErrorCode.NAME_EMPTY
			);
		}

		if (name.length() > MAX_PRODUCT_NAME_TYPE_LENGTH) {
			throw new ProductTypeNameException(
					ProductTypeNameException.ErrorCode.NAME_TOO_LONG
			);
		}
	}
}