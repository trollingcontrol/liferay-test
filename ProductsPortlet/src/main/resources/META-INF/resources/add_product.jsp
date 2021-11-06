<%@ include file="init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addProduct" var="addProductURL" />

<aui:form action="<%= addProductURL %>" name="<portlet:namespace />addProductForm">
    <aui:fieldset>
        <aui:input name="name" />
        <aui:input name="typeId" />
        <aui:input name="amount" />
        <aui:input name="cost" />
        <aui:input name="present" type="checkbox" />
        <aui:input name="archived" type="checkbox" />
        <aui:input name="description" type="textarea" />
    </aui:fieldset>

    <liferay-ui:error key="invalidNumbers" message="invalid-numbers" />
    <liferay-ui:error key="nameEmpty" message="name-empty" />
    <liferay-ui:error key="invalidCost" message="invalid-cost" />
    <liferay-ui:error key="nameTooLong" message="name-too-long" />
    <liferay-ui:error key="invalidAmount" message="invalid-amount" />
    <liferay-ui:error key="descriptionEmpty" message="description-empty" />
    <liferay-ui:error key="descriptionTooLong" message="description-too-long" />
    <liferay-ui:error key="productTypeIdNotFound" message="product-type-id-not-found" />
    <liferay-ui:error key="errorAddingProduct" message="error-adding-product" />

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button type="cancel" onClick="<%= viewURL %>" />
    </aui:button-row>
</aui:form>