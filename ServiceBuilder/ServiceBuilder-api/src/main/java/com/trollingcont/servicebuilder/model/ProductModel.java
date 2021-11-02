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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Product service. Represents a row in the &quot;LS_Product&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.trollingcont.servicebuilder.model.impl.ProductModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.trollingcont.servicebuilder.model.impl.ProductImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Product
 * @generated
 */
@ProviderType
public interface ProductModel extends BaseModel<Product> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a product model instance should use the {@link Product} interface instead.
	 */

	/**
	 * Returns the primary key of this product.
	 *
	 * @return the primary key of this product
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this product.
	 *
	 * @param primaryKey the primary key of this product
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this product.
	 *
	 * @return the uuid of this product
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this product.
	 *
	 * @param uuid the uuid of this product
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the product ID of this product.
	 *
	 * @return the product ID of this product
	 */
	public long getProductId();

	/**
	 * Sets the product ID of this product.
	 *
	 * @param productId the product ID of this product
	 */
	public void setProductId(long productId);

	/**
	 * Returns the name of this product.
	 *
	 * @return the name of this product
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this product.
	 *
	 * @param name the name of this product
	 */
	public void setName(String name);

	/**
	 * Returns the product type ID of this product.
	 *
	 * @return the product type ID of this product
	 */
	public long getProductTypeId();

	/**
	 * Sets the product type ID of this product.
	 *
	 * @param productTypeId the product type ID of this product
	 */
	public void setProductTypeId(long productTypeId);

	/**
	 * Returns the cost of this product.
	 *
	 * @return the cost of this product
	 */
	public long getCost();

	/**
	 * Sets the cost of this product.
	 *
	 * @param cost the cost of this product
	 */
	public void setCost(long cost);

	/**
	 * Returns the amount of this product.
	 *
	 * @return the amount of this product
	 */
	public long getAmount();

	/**
	 * Sets the amount of this product.
	 *
	 * @param amount the amount of this product
	 */
	public void setAmount(long amount);

	/**
	 * Returns the present of this product.
	 *
	 * @return the present of this product
	 */
	public Boolean getPresent();

	/**
	 * Sets the present of this product.
	 *
	 * @param present the present of this product
	 */
	public void setPresent(Boolean present);

	/**
	 * Returns the archived of this product.
	 *
	 * @return the archived of this product
	 */
	public Boolean getArchived();

	/**
	 * Sets the archived of this product.
	 *
	 * @param archived the archived of this product
	 */
	public void setArchived(Boolean archived);

	/**
	 * Returns the description of this product.
	 *
	 * @return the description of this product
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this product.
	 *
	 * @param description the description of this product
	 */
	public void setDescription(String description);

}