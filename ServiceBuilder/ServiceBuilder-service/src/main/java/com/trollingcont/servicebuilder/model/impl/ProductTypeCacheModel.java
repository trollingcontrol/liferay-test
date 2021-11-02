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

import com.trollingcont.servicebuilder.model.ProductType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProductType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductTypeCacheModel
	implements CacheModel<ProductType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductTypeCacheModel)) {
			return false;
		}

		ProductTypeCacheModel productTypeCacheModel =
			(ProductTypeCacheModel)object;

		if (productTypeId == productTypeCacheModel.productTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, productTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", productTypeId=");
		sb.append(productTypeId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProductType toEntityModel() {
		ProductTypeImpl productTypeImpl = new ProductTypeImpl();

		if (uuid == null) {
			productTypeImpl.setUuid("");
		}
		else {
			productTypeImpl.setUuid(uuid);
		}

		productTypeImpl.setProductTypeId(productTypeId);

		if (name == null) {
			productTypeImpl.setName("");
		}
		else {
			productTypeImpl.setName(name);
		}

		productTypeImpl.resetOriginalValues();

		return productTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		productTypeId = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(productTypeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public String uuid;
	public long productTypeId;
	public String name;

}