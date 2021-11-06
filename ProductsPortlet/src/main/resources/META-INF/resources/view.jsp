<%@ include file="init.jsp" %>

<portlet:renderURL var="addProductURL">
    <portlet:param name="mvcPath" value="/add_product.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editProductURL">
    <portlet:param name="mvcPath" value="/edit_product.jsp" />
</portlet:renderURL>

<aui:button-row>
    <aui:button onClick="<%= addProductURL %>" value="+" />
</aui:button-row>

<liferay-ui:error key="invalidProductId" message="invalid-product-id" />
<liferay-ui:error key="productIdNotFound" message="product-id-not-found" />
<liferay-ui:error key="errorDeletingProduct" message="error-deleting-product" />
<liferay-ui:error key="errorDeletingProduct" message="error-deleting-product" />

<liferay-ui:search-container total="<%= ProductLocalServiceUtil.getProductsCount() %>">
    <liferay-ui:search-container-results
            results="<%= ProductLocalServiceUtil.getProducts(
				searchContainer.getStart(),
				searchContainer.getEnd()) 
			%>"
    />

    <liferay-ui:search-container-row
            className="com.trollingcont.servicebuilder.model.Product"
            modelVar="product">

        <liferay-ui:search-container-column-text property="productId" name="ID" />
        <liferay-ui:search-container-column-text property="name" name="Name" />
		<liferay-ui:search-container-column-text property="productTypeId" name="Type ID" />
		<liferay-ui:search-container-column-text value="<%= String.format("%.2f", (float)product.getCost() / 100) %>" name="Cost" />
		<liferay-ui:search-container-column-text property="amount" name="Amount" />
		<liferay-ui:search-container-column-text value="<%= product.getPresent() ? "Yes" : "No" %>" name="Is present?" />
		<liferay-ui:search-container-column-text value="<%= product.getArchived() ? "Yes" : "No" %>" name="Is archived?" />
		<liferay-ui:search-container-column-text property="description" name="Description" />
        <liferay-ui:search-container-column-jsp path="/product_actions.jsp" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

</liferay-ui:search-container>

<liferay-ui:success key="productAdded" message="product-added" />
<liferay-ui:success key="productDeleted" message="product-deleted" />
<liferay-ui:success key="productUpdated" message="product-updated" />