<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.11.2021
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/guestportlet/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addProductType" var="addProductTypeURL"></portlet:actionURL>

<aui:form action="<%= addProductTypeURL %>" name="<portlet:namespace />fm">
    <aui:fieldset>
        <aui:input name="productType"></aui:input>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
    </aui:button-row>
</aui:form>

<liferay-ui:success key="productTypeAdded" message="product-type-added" />

<liferay-ui:error key="missingProductTypeName" message="missing-product-type-name" />
<liferay-ui:error key="failedToAddProductType" message="failed-to-add-product-type" />