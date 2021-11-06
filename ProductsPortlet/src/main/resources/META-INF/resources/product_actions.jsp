<%@ include file="init.jsp" %>

<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Product product = (Product) row.getObject();

	String id = Long.toString(product.getProductId());
	String name = product.getName();
	String typeId = Long.toString(product.getProductTypeId());
	String cost = Long.toString(product.getCost());
	String amount = Long.toString(product.getAmount());
	String present = Boolean.toString(product.getPresent());
	String archived = Boolean.toString(product.getArchived());
	String description = product.getDescription();
%>

<portlet:actionURL name="deleteProduct" var="deleteProductURL">
	<portlet:param name="productIdToBeDeleted" value="<%= id %>" />
</portlet:actionURL>

<portlet:renderURL var="editProductURL">
    <portlet:param name="mvcPath" value="/edit_product.jsp" />
	<portlet:param name="id" value="<%= id %>" />
	<portlet:param name="name" value="<%= name %>" />
	<portlet:param name="typeId" value="<%= typeId %>" />
	<portlet:param name="cost" value="<%= cost %>" />
	<portlet:param name="amount" value="<%= amount %>" />
	<portlet:param name="present" value="<%= present %>" />
	<portlet:param name="archived" value="<%= archived %>" />
	<portlet:param name="description" value="<%= description %>" />
</portlet:renderURL>

<aui:button-row>
    <aui:button value="Delete" onClick="<%= deleteProductURL %>" />
    <aui:button value="Edit" onClick="<%= editProductURL %>" />
</aui:button-row>