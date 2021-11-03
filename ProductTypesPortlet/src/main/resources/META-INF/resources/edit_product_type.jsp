<%@ taglib prefix="portlet-ui" uri="http://liferay.com/tld/ui" %>
<%@ include file="init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editProductType" var="editProductTypeURL" />
<portlet:actionURL name="deleteProductType" var="deleteProductTypeURL"/>
<portlet:actionURL name="findProductType" var="findProductTypeURL"/>

<script>
    function submitForm(action) {
        const form = document.forms['<portlet:namespace/>editForm']

        if (action === 'delete') {
            form.action = '<%= deleteProductTypeURL %>'
        }
        else if (action === 'edit') {
            form.action = '<%= editProductTypeURL %>'
        }
        else if (action === 'find') {
            form.action = '<%= findProductTypeURL %>'
        }

        form.submit()
    }
</script>

<p><%= request.getAttribute("productTypeName") %></p>

<aui:form action="<%= deleteProductTypeURL  %>" name="editForm" method="post">
    <aui:fieldset>
        <aui:input name="productTypeId" />
        <aui:input name="productTypeName" value='<%= request.getAttribute("productTypeName") %>' />
    </aui:fieldset>

    <liferay-ui:error key="productTypeNameTooLong" message="product-type-name-too-long" />
    <liferay-ui:error key="missingProductTypeName" message="missing-product-type-name" />
    <liferay-ui:error key="failedToAddProductType" message="failed-to-add-product-type" />
    <liferay-ui:error key="failedToAddProductType" message="failed-to-add-product-type" />
    <liferay-ui:error key="productTypeNameAlreadyExists" message="product-type-name-already-exists" />
    <liferay-ui:error key="productTypeNotFound" message="product-type-not-found" />
    <liferay-ui:error key="errorDeletingProductType" message="error-deleting-product-type" />
    <liferay-ui:error key="invalidProductTypeId" message="invalid-product-type-id" />
    <liferay-ui:error key="errorGettingProductType" message="error-getting-product-type" />

    <aui:button-row>
        <aui:button value="delete-button" cssClass="RedButton" onClick="submitForm('delete')" />
        <aui:button value="find-button" onClick="submitForm('find')" />
        <aui:button value="edit-button" onClick="submitForm('edit')" />
        <aui:button type="cancel" onClick="<%= viewURL %>" />
    </aui:button-row>
</aui:form>