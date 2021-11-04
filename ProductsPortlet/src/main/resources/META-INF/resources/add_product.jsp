<%@ include file="init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addProduct" var="addProductURL" />

<aui:form action="<%= addProductURL %>" name="<portlet:namespace />addProductForm">
    <aui:fieldset>
        <aui:input name="productName" />
        <aui:input name="productTypeId" />
        <aui:input name="amount" />
        <aui:input name="cost" />
        <aui:input name="present" type="checkbox" />
        <aui:input name="archived" type="checkbox" />
        <aui:input name="description" type="textarea" />
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button type="cancel" onClick="<%= viewURL %>" />
    </aui:button-row>
</aui:form>