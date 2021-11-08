<%@ include file="init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addPurchaseType" var="addPurchaseTypeURL" />

<aui:form action="<%= addPurchaseTypeURL %>" name="<portlet:namespace />addPurchaseTypeForm">
    <aui:fieldset>
        <aui:input name="name" />
    </aui:fieldset>

    <liferay-ui:error key="nameTooLong" message="name-too-long" />
    <liferay-ui:error key="nameEmpty" message="name-empty" />
    <liferay-ui:error key="errorAddingPost" message="error-adding-post" />

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button type="cancel" onClick="<%= viewURL %>" />
    </aui:button-row>
</aui:form>