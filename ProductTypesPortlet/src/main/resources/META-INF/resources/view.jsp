<%@ include file="init.jsp" %>

<portlet:renderURL var="addProductTypeURL">
    <portlet:param name="mvcPath" value="/add_product_type.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editProductTypeURL">
    <portlet:param name="mvcPath" value="/edit_product_type.jsp" />
</portlet:renderURL>

<aui:button-row>
    <aui:button onClick="<%= addProductTypeURL %>" value="+" />
</aui:button-row>

<liferay-ui:search-container total="<%= ProductTypeLocalServiceUtil.getProductTypesCount() %>">
    <liferay-ui:search-container-results
            results="<%= ProductTypeLocalServiceUtil.getProductTypes(
                    searchContainer.getStart(), searchContainer.getEnd()
                    ) %>"
    />

    <liferay-ui:search-container-row
            className="com.trollingcont.servicebuilder.model.ProductType"
            modelVar="productType">

        <liferay-ui:search-container-column-text property="productTypeId" name="ID" />
        <liferay-ui:search-container-column-text property="name" name="Name" />
        <liferay-ui:search-container-column-jsp path="/product_types_actions.jsp" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

</liferay-ui:search-container>

<liferay-ui:success key="productNameNotChanged" message="product-type-name-not-changed" />
<liferay-ui:success key="productTypeAdded" message="product-type-added" />
<liferay-ui:success key="productTypeDeleted" message="product-type-deleted" />
<liferay-ui:success key="productTypeUpdated" message="product-type-updated" />