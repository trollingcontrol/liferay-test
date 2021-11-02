<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.11.2021
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/guestportlet/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addProduct" var="addProductURL"></portlet:actionURL>

<aui:form action="<%= addProductURL %>" name="<portlet:namespace />fm">
    <aui:fieldset>
        <aui:input name="name"></aui:input>
        <aui:input name="typeId"></aui:input>
        <aui:input name="cost"></aui:input>
        <aui:input name="amount"></aui:input>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
    </aui:button-row>
</aui:form>