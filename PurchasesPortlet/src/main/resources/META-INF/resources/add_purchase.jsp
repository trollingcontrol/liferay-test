<%@ include file="init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addPurchase" var="addPurchaseURL" />

<aui:form action="<%= addPurchaseURL %>" name="<portlet:namespace />addPurchaseForm">
    <aui:fieldset>
        <aui:input name="productId" />
        <aui:input name="employeeId" />
        <aui:input name="purchaseTypeId" />
    </aui:fieldset>

    <liferay-ui:error key="productIsMissing" message="product-is-missing" />
    <liferay-ui:error key="accessDenied" message="access-denied" />
    <liferay-ui:error key="invalidNumbers" message="invalid-numbers" />
    <liferay-ui:error key="purchasedProductNotFound" message="purchased-product-not-found" />
    <liferay-ui:error key="employeeNotFound" message="employee-not-found" />
    <liferay-ui:error key="purchaseTypeNotFound" message="purchase-type-not-found" />
    <liferay-ui:error key="errorAddingPurchase" message="error-adding-purchase" />

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button type="cancel" onClick="<%= viewURL %>" />
    </aui:button-row>
</aui:form>