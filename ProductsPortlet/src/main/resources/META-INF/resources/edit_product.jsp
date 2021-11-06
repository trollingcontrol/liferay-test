<%@ include file="init.jsp" %>

<%
    String id = ParamUtil.getString(request, "id");
	String name = ParamUtil.getString(request, "name");
	String typeId = ParamUtil.getString(request, "typeId");
	String cost = String.format("%.2f", (float)ParamUtil.getLong(request, "cost") / 100);
	String amount = ParamUtil.getString(request,"amount");
	boolean present = ParamUtil.getBoolean(request,"present");
	boolean archived = ParamUtil.getBoolean(request,"archived");
	String description = ParamUtil.getString(request,"description");

	String information = String.format(
			"Current product data<br>ID: %s<br>Name: %s<br>Type ID: %s<br>Cost: %s RUB<br>Amount: %s<br>Present: %s<br>Archived: %s<br>Description<br>%s",
			id,
			name,
			typeId,
			cost,
			amount,
			present ? "Yes" : "No",
			archived ? "Yes" : "No",
			description
	);
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editProduct" var="editProductURL">
    <portlet:param name="id" value="<%= id %>" />
</portlet:actionURL>

<p>
    <%= information %>
</P>

<aui:form action="<%= editProductURL %>" name="editProductForm">

    <liferay-ui:error key="invalidNumbers" message="invalid-numbers" />
    <liferay-ui:error key="nameEmpty" message="name-empty" />
    <liferay-ui:error key="invalidCost" message="invalid-cost" />
    <liferay-ui:error key="nameTooLong" message="name-too-long" />
    <liferay-ui:error key="invalidAmount" message="invalid-amount" />
    <liferay-ui:error key="descriptionEmpty" message="description-empty" />
    <liferay-ui:error key="descriptionTooLong" message="description-too-long" />
    <liferay-ui:error key="productTypeIdNotFound" message="product-type-id-not-found" />
    <liferay-ui:error key="errorUpdaingProduct" message="error-updating-product" />

    <aui:fieldset>
        <aui:input name="newName" value="<%= name %>" />
        <aui:input name="newTypeId" value="<%= typeId %>" />
        <aui:input name="newCost" value="<%= cost %>" />
        <aui:input name="newAmount" value="<%= amount %>" />
        <aui:input name="newPresent" checked="<%= present %>" type="checkbox" />
        <aui:input name="newArchived" checked="<%= archived %>" type="checkbox" />
        <aui:input name="newDescription" value="<%= description %>" type="textarea" />
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button type="cancel" onClick="<%= viewURL %>" />
    </aui:button-row>

</aui:form>