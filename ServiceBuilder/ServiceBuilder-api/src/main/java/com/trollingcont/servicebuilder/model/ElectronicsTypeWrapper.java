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
 * This class is a wrapper for {@link ElectronicsType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectronicsType
 * @generated
 */
public class ElectronicsTypeWrapper
	extends BaseModelWrapper<ElectronicsType>
	implements ElectronicsType, ModelWrapper<ElectronicsType> {

	public ElectronicsTypeWrapper(ElectronicsType electronicsType) {
		super(electronicsType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("productTypeId", getProductTypeId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long productTypeId = (Long)attributes.get("productTypeId");

		if (productTypeId != null) {
			setProductTypeId(productTypeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	 * Returns the name of this electronics type.
	 *
	 * @return the name of this electronics type
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this electronics type.
	 *
	 * @return the primary key of this electronics type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product type ID of this electronics type.
	 *
	 * @return the product type ID of this electronics type
	 */
	@Override
	public long getProductTypeId() {
		return model.getProductTypeId();
	}

	/**
	 * Returns the uuid of this electronics type.
	 *
	 * @return the uuid of this electronics type
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
	 * Sets the name of this electronics type.
	 *
	 * @param name the name of this electronics type
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this electronics type.
	 *
	 * @param primaryKey the primary key of this electronics type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product type ID of this electronics type.
	 *
	 * @param productTypeId the product type ID of this electronics type
	 */
	@Override
	public void setProductTypeId(long productTypeId) {
		model.setProductTypeId(productTypeId);
	}

	/**
	 * Sets the uuid of this electronics type.
	 *
	 * @param uuid the uuid of this electronics type
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ElectronicsTypeWrapper wrap(ElectronicsType electronicsType) {
		return new ElectronicsTypeWrapper(electronicsType);
	}

}