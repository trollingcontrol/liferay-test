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

package com.trollingcont.servicebuilder.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.trollingcont.servicebuilder.model.EmployeeRight;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EmployeeRight in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeRightCacheModel
	implements CacheModel<EmployeeRight>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeRightCacheModel)) {
			return false;
		}

		EmployeeRightCacheModel employeeRightCacheModel =
			(EmployeeRightCacheModel)object;

		if (rightId == employeeRightCacheModel.rightId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, rightId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{rightId=");
		sb.append(rightId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", productTypeId=");
		sb.append(productTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeRight toEntityModel() {
		EmployeeRightImpl employeeRightImpl = new EmployeeRightImpl();

		employeeRightImpl.setRightId(rightId);
		employeeRightImpl.setEmployeeId(employeeId);
		employeeRightImpl.setProductTypeId(productTypeId);

		employeeRightImpl.resetOriginalValues();

		return employeeRightImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		rightId = objectInput.readLong();

		employeeId = objectInput.readLong();

		productTypeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(rightId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(productTypeId);
	}

	public long rightId;
	public long employeeId;
	public long productTypeId;

}