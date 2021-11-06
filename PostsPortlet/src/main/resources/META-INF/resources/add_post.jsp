<%@ include file="init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addPost" var="addPostURL" />

<aui:form action="<%= addPostURL %>" name="<portlet:namespace />addPostForm">
    <aui:fieldset>
        <aui:input name="name" />
    </aui:fieldset>

    <liferay-ui:error key="productTypeNameTooLong" message="product-type-name-too-long" />
    <liferay-ui:error key="missingProductTypeName" message="missing-product-type-name" />
    <liferay-ui:error key="failedToAddProductType" message="failed-to-add-product-type" />

    <aui:button-row>
        <aui:button value="add-button" type="submit" />
        <aui:button type="cancel" onClick="<%= viewURL %>" />
    </aui:button-row>
</aui:form>