<%@ include file="../init.jsp" %>

<portlet:renderURL var="addProductURL">
    <portlet:param name="mvcPath" value="/guestportlet/create_product.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="createProductTypeURL">
    <portlet:param name="mvcPath" value="/guestportlet/create_product_type.jsp"></portlet:param>
</portlet:renderURL>

<aui:button-row>
    <aui:button onClick="<%= addProductURL %>" value="Add product"></aui:button>
</aui:button-row>

<aui:button-row>
    <aui:button onClick="<%= createProductTypeURL %>" value="Add product type"></aui:button>
</aui:button-row>