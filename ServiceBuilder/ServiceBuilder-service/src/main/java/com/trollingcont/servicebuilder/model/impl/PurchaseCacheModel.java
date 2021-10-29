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

import com.trollingcont.servicebuilder.model.Purchase;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Purchase in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PurchaseCacheModel
	implements CacheModel<Purchase>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PurchaseCacheModel)) {
			return false;
		}

		PurchaseCacheModel purchaseCacheModel = (PurchaseCacheModel)object;

		if (purchaseId == purchaseCacheModel.purchaseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, purchaseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", purchaseId=");
		sb.append(purchaseId);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", datePurchased=");
		sb.append(datePurchased);
		sb.append(", purchaseTypeId=");
		sb.append(purchaseTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Purchase toEntityModel() {
		PurchaseImpl purchaseImpl = new PurchaseImpl();

		if (uuid == null) {
			purchaseImpl.setUuid("");
		}
		else {
			purchaseImpl.setUuid(uuid);
		}

		purchaseImpl.setPurchaseId(purchaseId);
		purchaseImpl.setProductId(productId);
		purchaseImpl.setEmployeeId(employeeId);

		if (datePurchased == Long.MIN_VALUE) {
			purchaseImpl.setDatePurchased(null);
		}
		else {
			purchaseImpl.setDatePurchased(new Date(datePurchased));
		}

		purchaseImpl.setPurchaseTypeId(purchaseTypeId);

		purchaseImpl.resetOriginalValues();

		return purchaseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		purchaseId = objectInput.readLong();

		productId = objectInput.readLong();

		employeeId = objectInput.readLong();
		datePurchased = objectInput.readLong();

		purchaseTypeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(purchaseId);

		objectOutput.writeLong(productId);

		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(datePurchased);

		objectOutput.writeLong(purchaseTypeId);
	}

	public String uuid;
	public long purchaseId;
	public long productId;
	public long employeeId;
	public long datePurchased;
	public long purchaseTypeId;

}