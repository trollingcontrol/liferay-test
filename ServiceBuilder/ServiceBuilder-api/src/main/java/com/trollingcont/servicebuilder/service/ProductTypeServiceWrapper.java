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

package com.trollingcont.servicebuilder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductTypeService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductTypeService
 * @generated
 */
public class ProductTypeServiceWrapper
	implements ProductTypeService, ServiceWrapper<ProductTypeService> {

	public ProductTypeServiceWrapper(ProductTypeService productTypeService) {
		_productTypeService = productTypeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productTypeService.getOSGiServiceIdentifier();
	}

	@Override
	public ProductTypeService getWrappedService() {
		return _productTypeService;
	}

	@Override
	public void setWrappedService(ProductTypeService productTypeService) {
		_productTypeService = productTypeService;
	}

	private ProductTypeService _productTypeService;

}