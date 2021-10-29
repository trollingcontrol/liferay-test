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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.trollingcont.servicebuilder.service.http.PurchaseServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PurchaseSoap implements Serializable {

	public static PurchaseSoap toSoapModel(Purchase model) {
		PurchaseSoap soapModel = new PurchaseSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPurchaseId(model.getPurchaseId());
		soapModel.setProductId(model.getProductId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setDatePurchased(model.getDatePurchased());
		soapModel.setPurchaseType(model.getPurchaseType());

		return soapModel;
	}

	public static PurchaseSoap[] toSoapModels(Purchase[] models) {
		PurchaseSoap[] soapModels = new PurchaseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PurchaseSoap[][] toSoapModels(Purchase[][] models) {
		PurchaseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PurchaseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PurchaseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PurchaseSoap[] toSoapModels(List<Purchase> models) {
		List<PurchaseSoap> soapModels = new ArrayList<PurchaseSoap>(
			models.size());

		for (Purchase model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PurchaseSoap[soapModels.size()]);
	}

	public PurchaseSoap() {
	}

	public long getPrimaryKey() {
		return _purchaseId;
	}

	public void setPrimaryKey(long pk) {
		setPurchaseId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPurchaseId() {
		return _purchaseId;
	}

	public void setPurchaseId(long purchaseId) {
		_purchaseId = purchaseId;
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public Date getDatePurchased() {
		return _datePurchased;
	}

	public void setDatePurchased(Date datePurchased) {
		_datePurchased = datePurchased;
	}

	public long getPurchaseType() {
		return _purchaseType;
	}

	public void setPurchaseType(long purchaseType) {
		_purchaseType = purchaseType;
	}

	private String _uuid;
	private long _purchaseId;
	private long _productId;
	private long _employeeId;
	private Date _datePurchased;
	private long _purchaseType;

}