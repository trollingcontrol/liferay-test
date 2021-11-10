<%@ include file="init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/guestportlet/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addProduct" var="addProductURL" />

<aui:form action="<%= addProductURL %>" name="<portlet:namespace />fm">
    <aui:fieldset>
        <aui:input name="name" />
        <aui:input name="typeId" />
        <aui:input name="cost" />
        <aui:input name="amount" />
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button type="cancel" onClick="<%= viewURL %>" />
    </aui:button-row>
</aui:form>