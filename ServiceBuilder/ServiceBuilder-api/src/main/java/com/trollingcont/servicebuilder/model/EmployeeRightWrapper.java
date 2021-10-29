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
 * This class is a wrapper for {@link EmployeeRight}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeRight
 * @generated
 */
public class EmployeeRightWrapper
	extends BaseModelWrapper<EmployeeRight>
	implements EmployeeRight, ModelWrapper<EmployeeRight> {

	public EmployeeRightWrapper(EmployeeRight employeeRight) {
		super(employeeRight);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("rightId", getRightId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("productTypeId", getProductTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long rightId = (Long)attributes.get("rightId");

		if (rightId != null) {
			setRightId(rightId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long productTypeId = (Long)attributes.get("productTypeId");

		if (productTypeId != null) {
			setProductTypeId(productTypeId);
		}
	}

	/**
	 * Returns the employee ID of this employee right.
	 *
	 * @return the employee ID of this employee right
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the primary key of this employee right.
	 *
	 * @return the primary key of this employee right
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product type ID of this employee right.
	 *
	 * @return the product type ID of this employee right
	 */
	@Override
	public long getProductTypeId() {
		return model.getProductTypeId();
	}

	/**
	 * Returns the right ID of this employee right.
	 *
	 * @return the right ID of this employee right
	 */
	@Override
	public long getRightId() {
		return model.getRightId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the employee ID of this employee right.
	 *
	 * @param employeeId the employee ID of this employee right
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the primary key of this employee right.
	 *
	 * @param primaryKey the primary key of this employee right
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product type ID of this employee right.
	 *
	 * @param productTypeId the product type ID of this employee right
	 */
	@Override
	public void setProductTypeId(long productTypeId) {
		model.setProductTypeId(productTypeId);
	}

	/**
	 * Sets the right ID of this employee right.
	 *
	 * @param rightId the right ID of this employee right
	 */
	@Override
	public void setRightId(long rightId) {
		model.setRightId(rightId);
	}

	@Override
	protected EmployeeRightWrapper wrap(EmployeeRight employeeRight) {
		return new EmployeeRightWrapper(employeeRight);
	}

}