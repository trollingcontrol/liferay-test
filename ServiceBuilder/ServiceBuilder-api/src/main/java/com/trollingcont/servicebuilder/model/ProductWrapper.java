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
 * This class is a wrapper for {@link Product}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Product
 * @generated
 */
public class ProductWrapper
	extends BaseModelWrapper<Product>
	implements ModelWrapper<Product>, Product {

	public ProductWrapper(Product product) {
		super(product);
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
	 * Returns the amount of this product.
	 *
	 * @return the amount of this product
	 */
	@Override
	public long getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the archived of this product.
	 *
	 * @return the archived of this product
	 */
	@Override
	public Boolean getArchived() {
		return model.getArchived();
	}

	/**
	 * Returns the cost of this product.
	 *
	 * @return the cost of this product
	 */
	@Override
	public long getCost() {
		return model.getCost();
	}

	/**
	 * Returns the description of this product.
	 *
	 * @return the description of this product
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the name of this product.
	 *
	 * @return the name of this product
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the present of this product.
	 *
	 * @return the present of this product
	 */
	@Override
	public Boolean getPresent() {
		return model.getPresent();
	}

	/**
	 * Returns the primary key of this product.
	 *
	 * @return the primary key of this product
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product ID of this product.
	 *
	 * @return the product ID of this product
	 */
	@Override
	public long getProductId() {
		return model.getProductId();
	}

	/**
	 * Returns the product type ID of this product.
	 *
	 * @return the product type ID of this product
	 */
	@Override
	public long getProductTypeId() {
		return model.getProductTypeId();
	}

	/**
	 * Returns the uuid of this product.
	 *
	 * @return the uuid of this product
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
	 * Sets the amount of this product.
	 *
	 * @param amount the amount of this product
	 */
	@Override
	public void setAmount(long amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the archived of this product.
	 *
	 * @param archived the archived of this product
	 */
	@Override
	public void setArchived(Boolean archived) {
		model.setArchived(archived);
	}

	/**
	 * Sets the cost of this product.
	 *
	 * @param cost the cost of this product
	 */
	@Override
	public void setCost(long cost) {
		model.setCost(cost);
	}

	/**
	 * Sets the description of this product.
	 *
	 * @param description the description of this product
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the name of this product.
	 *
	 * @param name the name of this product
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the present of this product.
	 *
	 * @param present the present of this product
	 */
	@Override
	public void setPresent(Boolean present) {
		model.setPresent(present);
	}

	/**
	 * Sets the primary key of this product.
	 *
	 * @param primaryKey the primary key of this product
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product ID of this product.
	 *
	 * @param productId the product ID of this product
	 */
	@Override
	public void setProductId(long productId) {
		model.setProductId(productId);
	}

	/**
	 * Sets the product type ID of this product.
	 *
	 * @param productTypeId the product type ID of this product
	 */
	@Override
	public void setProductTypeId(long productTypeId) {
		model.setProductTypeId(productTypeId);
	}

	/**
	 * Sets the uuid of this product.
	 *
	 * @param uuid the uuid of this product
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ProductWrapper wrap(Product product) {
		return new ProductWrapper(product);
	}

}