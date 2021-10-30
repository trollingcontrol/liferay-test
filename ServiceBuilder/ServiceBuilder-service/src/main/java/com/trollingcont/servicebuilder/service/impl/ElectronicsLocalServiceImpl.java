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

package com.trollingcont.servicebuilder.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.trollingcont.servicebuilder.exception.NoSuchElectronicsException;
import com.trollingcont.servicebuilder.model.Electronics;
import com.trollingcont.servicebuilder.service.base.ElectronicsLocalServiceBaseImpl;

import com.trollingcont.servicebuilder.service.persistence.ElectronicsPersistence;
import org.osgi.service.component.annotations.Component;

import javax.sound.sampled.Port;

/**
 * The implementation of the electronics local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.trollingcont.servicebuilder.service.ElectronicsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectronicsLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.trollingcont.servicebuilder.model.Electronics",
	service = AopService.class
)
public class ElectronicsLocalServiceImpl
	extends ElectronicsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.trollingcont.servicebuilder.service.ElectronicsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.trollingcont.servicebuilder.service.ElectronicsLocalServiceUtil</code>.
	 */

	public Electronics addElectronics(
			String name,
			long productTypeId, // LINK
			long cost,
			long amount,
			boolean present,
			boolean archived,
			String description,
			ServiceContext serviceContext
	) throws PortalException {

		validate(name, description, amount, cost);

		long entryId = counterLocalService.increment();

		Electronics electronics = electronicsPersistence.create(entryId);

		electronics.setUuid(serviceContext.getUuid());
		electronics.setName(name);
		electronics.setProductTypeId(productTypeId);
		electronics.setCost(cost);
		electronics.setAmount(amount);
		electronics.setPresent(present);
		electronics.setArchived(archived);
		electronics.setDescription(description);
		electronics.setExpandoBridgeAttributes(serviceContext);

		electronicsPersistence.update(electronics);

		return electronics;
	}

	public Electronics updateElectronics(
			long electronicsId,
			String name,
			long productTypeId, // LINK
			long cost,
			long amount,
			boolean present,
			boolean archived,
			String description,
			ServiceContext serviceContext
	) throws PortalException {

		validate(name, description, amount, cost);

		Electronics electronics = electronicsPersistence.fetchByPrimaryKey(electronicsId);

		electronics.setName(name);
		electronics.setProductTypeId(productTypeId);
		electronics.setCost(cost);
		electronics.setAmount(amount);
		electronics.setPresent(present);
		electronics.setArchived(archived);
		electronics.setDescription(description);
		electronics.setExpandoBridgeAttributes(serviceContext);

		electronicsPersistence.update(electronics);

		return electronics;
	}

	protected void validate(
			String name,
			String description,
			long amount,
			long cost
	) throws PortalException {

		if (name == null || name.isEmpty()) {
			throw new PortalException("Name is null or empty");
		}

		if (description == null || description.isEmpty()) {
			throw new PortalException("Descrption is null or empty");
		}

		if (cost < 0) {
			throw new PortalException("Cost is less then 0");
		}

		if (amount < 0) {
			throw new PortalException("Amount is less then 0");
		}

	}
}