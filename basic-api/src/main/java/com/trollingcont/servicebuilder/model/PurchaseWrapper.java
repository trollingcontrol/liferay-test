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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Purchase}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Purchase
 * @generated
 */
public class PurchaseWrapper
	extends BaseModelWrapper<Purchase>
	implements ModelWrapper<Purchase>, Purchase {

	public PurchaseWrapper(Purchase purchase) {
		super(purchase);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("purchaseId", getPurchaseId());
		attributes.put("productId", getProductId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("datePurchased", getDatePurchased());
		attributes.put("purchaseType", getPurchaseType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long purchaseId = (Long)attributes.get("purchaseId");

		if (purchaseId != null) {
			setPurchaseId(purchaseId);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Date datePurchased = (Date)attributes.get("datePurchased");

		if (datePurchased != null) {
			setDatePurchased(datePurchased);
		}

		Long purchaseType = (Long)attributes.get("purchaseType");

		if (purchaseType != null) {
			setPurchaseType(purchaseType);
		}
	}

	/**
	 * Returns the date purchased of this purchase.
	 *
	 * @return the date purchased of this purchase
	 */
	@Override
	public Date getDatePurchased() {
		return model.getDatePurchased();
	}

	/**
	 * Returns the employee ID of this purchase.
	 *
	 * @return the employee ID of this purchase
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the primary key of this purchase.
	 *
	 * @return the primary key of this purchase
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product ID of this purchase.
	 *
	 * @return the product ID of this purchase
	 */
	@Override
	public long getProductId() {
		return model.getProductId();
	}

	/**
	 * Returns the purchase ID of this purchase.
	 *
	 * @return the purchase ID of this purchase
	 */
	@Override
	public long getPurchaseId() {
		return model.getPurchaseId();
	}

	/**
	 * Returns the purchase type of this purchase.
	 *
	 * @return the purchase type of this purchase
	 */
	@Override
	public long getPurchaseType() {
		return model.getPurchaseType();
	}

	/**
	 * Returns the uuid of this purchase.
	 *
	 * @return the uuid of this purchase
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
	 * Sets the date purchased of this purchase.
	 *
	 * @param datePurchased the date purchased of this purchase
	 */
	@Override
	public void setDatePurchased(Date datePurchased) {
		model.setDatePurchased(datePurchased);
	}

	/**
	 * Sets the employee ID of this purchase.
	 *
	 * @param employeeId the employee ID of this purchase
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the primary key of this purchase.
	 *
	 * @param primaryKey the primary key of this purchase
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product ID of this purchase.
	 *
	 * @param productId the product ID of this purchase
	 */
	@Override
	public void setProductId(long productId) {
		model.setProductId(productId);
	}

	/**
	 * Sets the purchase ID of this purchase.
	 *
	 * @param purchaseId the purchase ID of this purchase
	 */
	@Override
	public void setPurchaseId(long purchaseId) {
		model.setPurchaseId(purchaseId);
	}

	/**
	 * Sets the purchase type of this purchase.
	 *
	 * @param purchaseType the purchase type of this purchase
	 */
	@Override
	public void setPurchaseType(long purchaseType) {
		model.setPurchaseType(purchaseType);
	}

	/**
	 * Sets the uuid of this purchase.
	 *
	 * @param uuid the uuid of this purchase
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected PurchaseWrapper wrap(Purchase purchase) {
		return new PurchaseWrapper(purchase);
	}

}