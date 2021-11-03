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

package com.trollingcont.servicebuilder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductTypeLocalService
 * @generated
 */
public class ProductTypeLocalServiceWrapper
	implements ProductTypeLocalService,
			   ServiceWrapper<ProductTypeLocalService> {

	public ProductTypeLocalServiceWrapper(
		ProductTypeLocalService productTypeLocalService) {

		_productTypeLocalService = productTypeLocalService;
	}

	/**
	 * Adds the product type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productType the product type
	 * @return the product type that was added
	 */
	@Override
	public com.trollingcont.servicebuilder.model.ProductType addProductType(
		com.trollingcont.servicebuilder.model.ProductType productType) {

		return _productTypeLocalService.addProductType(productType);
	}

	@Override
	public com.trollingcont.servicebuilder.model.ProductType addProductType(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productTypeLocalService.addProductType(name, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new product type with the primary key. Does not add the product type to the database.
	 *
	 * @param productTypeId the primary key for the new product type
	 * @return the new product type
	 */
	@Override
	public com.trollingcont.servicebuilder.model.ProductType createProductType(
		long productTypeId) {

		return _productTypeLocalService.createProductType(productTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productTypeLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the product type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productTypeId the primary key of the product type
	 * @return the product type that was removed
	 * @throws PortalException if a product type with the primary key could not be found
	 */
	@Override
	public com.trollingcont.servicebuilder.model.ProductType deleteProductType(
			long productTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productTypeLocalService.deleteProductType(productTypeId);
	}

	/**
	 * Deletes the product type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productType the product type
	 * @return the product type that was removed
	 */
	@Override
	public com.trollingcont.servicebuilder.model.ProductType deleteProductType(
		com.trollingcont.servicebuilder.model.ProductType productType) {

		return _productTypeLocalService.deleteProductType(productType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productTypeLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.trollingcont.servicebuilder.model.impl.ProductTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _productTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.trollingcont.servicebuilder.model.impl.ProductTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _productTypeLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productTypeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _productTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.trollingcont.servicebuilder.model.ProductType fetchProductType(
		long productTypeId) {

		return _productTypeLocalService.fetchProductType(productTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the product type with the primary key.
	 *
	 * @param productTypeId the primary key of the product type
	 * @return the product type
	 * @throws PortalException if a product type with the primary key could not be found
	 */
	@Override
	public com.trollingcont.servicebuilder.model.ProductType getProductType(
			long productTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productTypeLocalService.getProductType(productTypeId);
	}

	/**
	 * Returns a range of all the product types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.trollingcont.servicebuilder.model.impl.ProductTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product types
	 * @param end the upper bound of the range of product types (not inclusive)
	 * @return the range of product types
	 */
	@Override
	public java.util.List<com.trollingcont.servicebuilder.model.ProductType>
		getProductTypes(int start, int end) {

		return _productTypeLocalService.getProductTypes(start, end);
	}

	@Override
	public java.util.List<com.trollingcont.servicebuilder.model.ProductType>
			getProductTypesByProductTypeName(String name)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productTypeLocalService.getProductTypesByProductTypeName(name);
	}

	/**
	 * Returns the number of product types.
	 *
	 * @return the number of product types
	 */
	@Override
	public int getProductTypesCount() {
		return _productTypeLocalService.getProductTypesCount();
	}

	/**
	 * Updates the product type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productType the product type
	 * @return the product type that was updated
	 */
	@Override
	public com.trollingcont.servicebuilder.model.ProductType updateProductType(
		com.trollingcont.servicebuilder.model.ProductType productType) {

		return _productTypeLocalService.updateProductType(productType);
	}

	@Override
	public com.trollingcont.servicebuilder.model.ProductType updateProductType(
			com.trollingcont.servicebuilder.model.ProductType productType,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productTypeLocalService.updateProductType(
			productType, serviceContext);
	}

	@Override
	public ProductTypeLocalService getWrappedService() {
		return _productTypeLocalService;
	}

	@Override
	public void setWrappedService(
		ProductTypeLocalService productTypeLocalService) {

		_productTypeLocalService = productTypeLocalService;
	}

	private ProductTypeLocalService _productTypeLocalService;

}