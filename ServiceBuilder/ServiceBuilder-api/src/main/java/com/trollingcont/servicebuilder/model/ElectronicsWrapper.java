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
 * This class is a wrapper for {@link Electronics}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Electronics
 * @generated
 */
public class ElectronicsWrapper
	extends BaseModelWrapper<Electronics>
	implements Electronics, ModelWrapper<Electronics> {

	public ElectronicsWrapper(Electronics electronics) {
		super(electronics);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("productId", getProductId());
		attributes.put("name", getName());
		attributes.put("productTypeId", getProductTypeId());
		attributes.put("cost", getCost());
		attributes.put("amount", getAmount());
		attributes.put("present", getPresent());
		attributes.put("archived", getArchived());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long productTypeId = (Long)attributes.get("productTypeId");

		if (productTypeId != null) {
			setProductTypeId(productTypeId);
		}

		Long cost = (Long)attributes.get("cost");

		if (cost != null) {
			setCost(cost);
		}

		Long amount = (Long)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Boolean present = (Boolean)attributes.get("present");

		if (present != null) {
			setPresent(present);
		}

		Boolean archived = (Boolean)attributes.get("archived");

		if (archived != null) {
			setArchived(archived);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the amount of this electronics.
	 *
	 * @return the amount of this electronics
	 */
	@Override
	public long getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the archived of this electronics.
	 *
	 * @return the archived of this electronics
	 */
	@Override
	public Boolean getArchived() {
		return model.getArchived();
	}

	/**
	 * Returns the cost of this electronics.
	 *
	 * @return the cost of this electronics
	 */
	@Override
	public long getCost() {
		return model.getCost();
	}

	/**
	 * Returns the description of this electronics.
	 *
	 * @return the description of this electronics
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the name of this electronics.
	 *
	 * @return the name of this electronics
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the present of this electronics.
	 *
	 * @return the present of this electronics
	 */
	@Override
	public Boolean getPresent() {
		return model.getPresent();
	}

	/**
	 * Returns the primary key of this electronics.
	 *
	 * @return the primary key of this electronics
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product ID of this electronics.
	 *
	 * @return the product ID of this electronics
	 */
	@Override
	public long getProductId() {
		return model.getProductId();
	}

	/**
	 * Returns the product type ID of this electronics.
	 *
	 * @return the product type ID of this electronics
	 */
	@Override
	public long getProductTypeId() {
		return model.getProductTypeId();
	}

	/**
	 * Returns the uuid of this electronics.
	 *
	 * @return the uuid of this electronics
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
	 * Sets the amount of this electronics.
	 *
	 * @param amount the amount of this electronics
	 */
	@Override
	public void setAmount(long amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the archived of this electronics.
	 *
	 * @param archived the archived of this electronics
	 */
	@Override
	public void setArchived(Boolean archived) {
		model.setArchived(archived);
	}

	/**
	 * Sets the cost of this electronics.
	 *
	 * @param cost the cost of this electronics
	 */
	@Override
	public void setCost(long cost) {
		model.setCost(cost);
	}

	/**
	 * Sets the description of this electronics.
	 *
	 * @param description the description of this electronics
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the name of this electronics.
	 *
	 * @param name the name of this electronics
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the present of this electronics.
	 *
	 * @param present the present of this electronics
	 */
	@Override
	public void setPresent(Boolean present) {
		model.setPresent(present);
	}

	/**
	 * Sets the primary key of this electronics.
	 *
	 * @param primaryKey the primary key of this electronics
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product ID of this electronics.
	 *
	 * @param productId the product ID of this electronics
	 */
	@Override
	public void setProductId(long productId) {
		model.setProductId(productId);
	}

	/**
	 * Sets the product type ID of this electronics.
	 *
	 * @param productTypeId the product type ID of this electronics
	 */
	@Override
	public void setProductTypeId(long productTypeId) {
		model.setProductTypeId(productTypeId);
	}

	/**
	 * Sets the uuid of this electronics.
	 *
	 * @param uuid the uuid of this electronics
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ElectronicsWrapper wrap(Electronics electronics) {
		return new ElectronicsWrapper(electronics);
	}

}