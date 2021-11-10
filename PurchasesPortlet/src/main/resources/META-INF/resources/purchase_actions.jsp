<%@ include file="init.jsp" %>

<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    Purchase purchase = (Purchase) row.getObject();

    String id = Long.toString(purchase.getPurchaseId());
    String productId = Long.toString(purchase.getProductId());
%>

<portlet:actionURL name="deletePurchase" var="deletePurchaseURL">
    <portlet:param name="purchaseIdToBeDeleted" value="<%= id %>" />
    <portlet:param name="productId" value="<%= productId %>" />
</portlet:actionURL>

<aui:button-row>
    <aui:button value="Delete" onClick="<%= deletePurchaseURL %>" />
</aui:button-row>