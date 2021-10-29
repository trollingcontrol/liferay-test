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

import com.trollingcont.servicebuilder.model.Electronics;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Electronics in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ElectronicsCacheModel
	implements CacheModel<Electronics>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ElectronicsCacheModel)) {
			return false;
		}

		ElectronicsCacheModel electronicsCacheModel =
			(ElectronicsCacheModel)object;

		if (productId == electronicsCacheModel.productId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, productId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", productTypeId=");
		sb.append(productTypeId);
		sb.append(", cost=");
		sb.append(cost);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", present=");
		sb.append(present);
		sb.append(", archived=");
		sb.append(archived);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Electronics toEntityModel() {
		ElectronicsImpl electronicsImpl = new ElectronicsImpl();

		if (uuid == null) {
			electronicsImpl.setUuid("");
		}
		else {
			electronicsImpl.setUuid(uuid);
		}

		electronicsImpl.setProductId(productId);

		if (name == null) {
			electronicsImpl.setName("");
		}
		else {
			electronicsImpl.setName(name);
		}

		electronicsImpl.setProductTypeId(productTypeId);
		electronicsImpl.setCost(cost);
		electronicsImpl.setAmount(amount);
		electronicsImpl.setPresent(present);
		electronicsImpl.setArchived(archived);

		if (description == null) {
			electronicsImpl.setDescription("");
		}
		else {
			electronicsImpl.setDescription(description);
		}

		electronicsImpl.resetOriginalValues();

		return electronicsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		productId = objectInput.readLong();
		name = objectInput.readUTF();

		productTypeId = objectInput.readLong();

		cost = objectInput.readLong();

		amount = objectInput.readLong();

		present = objectInput.readBoolean();

		archived = objectInput.readBoolean();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(productId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(productTypeId);

		objectOutput.writeLong(cost);

		objectOutput.writeLong(amount);

		objectOutput.writeBoolean(present);

		objectOutput.writeBoolean(archived);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long productId;
	public String name;
	public long productTypeId;
	public long cost;
	public long amount;
	public boolean present;
	public boolean archived;
	public String description;

}