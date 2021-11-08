<%@ include file="init.jsp" %>

<%
    String id = ParamUtil.getString(request, "id");
%>

<p>Adding right for employee ID <%= id %></p>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/employee_rights.jsp" />
    <portlet:param name="id" value="<%= id %>" />
</portlet:renderURL>

<portlet:actionURL name="addRight" var="addRightURL">
    <portlet:param name="id" value="<%= id %>" />
</portlet:actionURL>

<aui:form action="<%= addRightURL %>" name="<portlet:namespace />addRightForm">
    <aui:fieldset>
        <aui:input name="typeId" />
    </aui:fieldset>

    <liferay-ui:error key="rightAlreadyExists" message="right-already-exists" />
    <liferay-ui:error key="invalidNumbers" message="invalid-numbers" />
    <liferay-ui:error key="productTypeNotFound" message="product-type-not-found" />
    <liferay-ui:error key="errorAddingRight" message="error-adding-right" />

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button type="cancel" onClick="<%= viewURL %>" />
    </aui:button-row>
</aui:form>