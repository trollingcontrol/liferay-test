<%@ taglib prefix="portlet-ui" uri="http://liferay.com/tld/ui" %>
<%@ include file="init.jsp" %>

<%
    String productTypeName = ParamUtil.getString(request, "productTypeName");
    String productTypeId = ParamUtil.getString(request, "productTypeId");

	String description = String.format(
			"Current product type data<br>ID: %s<br>Name: %s",
			productTypeId,
			productTypeName
	);
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editProductType" var="editProductTypeURL">
    <portlet:param name="productTypeId" value="<%= productTypeId %>" />
    <portlet:param name="productTypeName" value="<%= productTypeName %>" />
</portlet:actionURL>

<p>
    <%= description %>
</P>

<aui:form action="<%= editProductTypeURL %>" name="editForm">

    <aui:fieldset>
        <aui:input name="newProductTypeName" value="<%= productTypeName %>" />
    </aui:fieldset>

    <liferay-ui:error key="productTypeNameTooLong" message="product-type-name-too-long" />
    <liferay-ui:error key="missingProductTypeName" message="missing-product-type-name" />
    <liferay-ui:error key="productTypeNameAlreadyExists" message="product-type-name-already-exists" />
    <liferay-ui:error key="errorUpdatingProductType" message="error-updating-product-type" />

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button type="cancel" onClick="<%= viewURL %>" />
    </aui:button-row>

</aui:form>