<%@ page import="com.trollingcont.servicebuilder.model.PurchaseType" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ include file="init.jsp" %>

<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    PurchaseType purchaseType = (PurchaseType) row.getObject();

    String id = Long.toString(purchaseType.getPurchaseTypeId());
    String name = purchaseType.getName();
%>

<portlet:actionURL name="deletePurchaseType" var="deletePurchaseTypeURL">
    <portlet:param name="purchaseTypeIdToBeDeleted" value="<%= id %>" />
</portlet:actionURL>

<portlet:renderURL var="editPurchaseTypeURL">
    <portlet:param name="mvcPath" value="/edit_purchase_type.jsp" />
    <portlet:param name="id" value="<%= id %>" />
    <portlet:param name="name" value="<%= name %>" />
</portlet:renderURL>

<aui:button-row>
    <aui:button value="Delete" onClick="<%= deletePurchaseTypeURL %>" />
    <aui:button value="Edit" onClick="<%= editPurchaseTypeURL %>" />
</aui:button-row>