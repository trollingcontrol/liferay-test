<%@ include file="init.jsp" %>

<%
    String id = ParamUtil.getString(request, "id");
    String name = ParamUtil.getString(request, "name");

    String description = String.format(
            "Current purchase type information<br>ID: %s<br>Name: %s",
            name,
            id
    );
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editPurchaseType" var="editPurchaseTypeURL">
    <portlet:param name="id" value="<%= id %>" />
    <portlet:param name="name" value="<%= name %>" />
</portlet:actionURL>

<p>
    <%= description %>
</P>

<aui:form action="<%= editPurchaseTypeURL %>" name="editForm">

    <aui:fieldset>
        <aui:input name="newName" value="<%= name %>" />
    </aui:fieldset>

    <liferay-ui:error key="nameTooLong" message="name-too-long" />
    <liferay-ui:error key="nameEmpty" message="name-empty" />
    <liferay-ui:error key="purchaseTypeNotFound" message="purchase-type-not-found" />
    <liferay-ui:error key="errorUpdatingPurchaseType" message="error-updating-purchase-type" />

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button type="cancel" onClick="<%= viewURL %>" />
    </aui:button-row>

</aui:form>