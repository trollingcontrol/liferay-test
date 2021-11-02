<%@ include file="init.jsp" %>

<portlet:renderURL var="addProductTypeURL">
    <portlet:param name="mvcPath" value="/guestportlet/add_product_type.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addProductType" var="addProductTypeURL"></portlet:actionURL>

<aui:form action="<%= addProductTypeURL %>" name="<portlet:namespace />fm">
    <aui:fieldset>
        <aui:input name="productType"></aui:input>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
    </aui:button-row>
</aui:form>

<liferay-ui:success key="productTypeAdded" message="product-type-added" />
<liferay-ui:error key="productTypeNameTooLong" message="product-type-name-too-long" />
<liferay-ui:error key="missingProductTypeName" message="missing-product-type-name" />
<liferay-ui:error key="failedToAddProductType" message="failed-to-add-product-type" />

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

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

</liferay-ui:search-container>