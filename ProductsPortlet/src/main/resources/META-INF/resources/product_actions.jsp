<%@ include file="init.jsp" %>

<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Product product = (Product) row.getObject();

	String productId = Long.toString(product.getProductId());
	String name = product.getName();
	String productTypeId = Long.toString(product.getProductTypeId());
	String cost = Long.toString(product.getCost());
	String amount = Long.toString(product.getAmount());
	String present = Boolean.toString(product.getPresent());
	String archived = Boolean.toString(product.getArchived());
	String description = product.getDescription();
%>

<portlet:actionURL name="deleteProduct" var="deleteProductURL">
</portlet:actionURL>

<portlet:renderURL var="editProductURL">
    <portlet:param name="mvcPath" value="/edit_product.jsp" />
</portlet:renderURL>

<aui:button-row>
    <aui:button value="Delete" onClick="<%= deleteProductTypeURL %>" />
    <aui:button value="Edit" onClick="<%= editProductTypeURL %>" />
</aui:button-row>