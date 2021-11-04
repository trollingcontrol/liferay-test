<%@ include file="init.jsp" %>

<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	ProductType productType = (ProductType) row.getObject();
	String productTypeId = Long.toString(productType.getProductTypeId());
	String productTypeName = productType.getName();
%>

<portlet:actionURL name="deleteProductType" var="deleteProductTypeURL">
    <portlet:param name="productTypeIdToBeDeleted" value="<%= productTypeId %>" />
</portlet:actionURL>

<portlet:renderURL var="editProductTypeURL">
    <portlet:param name="mvcPath" value="/edit_product_type.jsp" />
    <portlet:param name="productTypeId" value="<%= productTypeId %>" />
    <portlet:param name="productTypeName" value="<%= productTypeName %>" />
</portlet:renderURL>

<aui:button-row>
    <aui:button value="Delete" onClick="<%= deleteProductTypeURL %>" />
    <aui:button value="Edit" onClick="<%= editProductTypeURL %>" />
</aui:button-row>