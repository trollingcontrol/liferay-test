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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.trollingcont.servicebuilder.service.http.EmployeeRightServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeRightSoap implements Serializable {

	public static EmployeeRightSoap toSoapModel(EmployeeRight model) {
		EmployeeRightSoap soapModel = new EmployeeRightSoap();

		soapModel.setRightId(model.getRightId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setProductTypeId(model.getProductTypeId());

		return soapModel;
	}

	public static EmployeeRightSoap[] toSoapModels(EmployeeRight[] models) {
		EmployeeRightSoap[] soapModels = new EmployeeRightSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeRightSoap[][] toSoapModels(EmployeeRight[][] models) {
		EmployeeRightSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeRightSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeRightSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeRightSoap[] toSoapModels(List<EmployeeRight> models) {
		List<EmployeeRightSoap> soapModels = new ArrayList<EmployeeRightSoap>(
			models.size());

		for (EmployeeRight model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeRightSoap[soapModels.size()]);
	}

	public EmployeeRightSoap() {
	}

	public long getPrimaryKey() {
		return _rightId;
	}

	public void setPrimaryKey(long pk) {
		setRightId(pk);
	}

	public long getRightId() {
		return _rightId;
	}

	public void setRightId(long rightId) {
		_rightId = rightId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getProductTypeId() {
		return _productTypeId;
	}

	public void setProductTypeId(long productTypeId) {
		_productTypeId = productTypeId;
	}

	private long _rightId;
	private long _employeeId;
	private long _productTypeId;

}