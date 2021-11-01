<%@ include file="../init.jsp" %>

<portlet:renderURL var="addProductURL">
    <portlet:param name="mvcPath" value="/guestportlet/create_product.jsp"></portlet:param>
</portlet:renderURL>

<aui:button-row>
    <aui:button onClick="<%= addProductURL %>" value="Add product"></aui:button>
</aui:button-row>