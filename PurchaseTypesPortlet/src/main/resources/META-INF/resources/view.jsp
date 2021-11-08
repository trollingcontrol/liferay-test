<%@ page import="com.trollingcont.servicebuilder.service.PurchaseTypeLocalServiceUtil" %>
<%@ include file="init.jsp" %>

<portlet:renderURL var="addPurchaseTypeURL">
	<portlet:param name="mvcPath" value="/add_purchase_type.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editPurchaseTypeURL">
	<portlet:param name="mvcPath" value="/edit_purchase_type.jsp" />
</portlet:renderURL>

<aui:button-row>
	<aui:button onClick="<%= addPurchaseTypeURL %>" value="+" />
</aui:button-row>

<liferay-ui:error key="purchaseTypeNotFound" message="purchase-type-not-found" />
<liferay-ui:error key="errorDeletingPurchaseType" message="error-deleting-purchase-type" />

<liferay-ui:search-container total="<%= PurchaseTypeLocalServiceUtil.getPurchaseTypesCount() %>">
	<liferay-ui:search-container-results
			results="<%= PurchaseTypeLocalServiceUtil.getPurchaseTypes(
                    searchContainer.getStart(), searchContainer.getEnd()
                    ) %>"
	/>

	<liferay-ui:search-container-row
			className="com.trollingcont.servicebuilder.model.PurchaseType"
			modelVar="purchaseType">

		<liferay-ui:search-container-column-text property="purchaseTypeId" name="ID" />
		<liferay-ui:search-container-column-text property="name" name="Name" />
		<liferay-ui:search-container-column-jsp path="/purchase_type_actions.jsp" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>

<liferay-ui:success key="purchaseTypeAdded" message="purchase-type-added" />
<liferay-ui:success key="purchaseTypeUpdated" message="purchase-type-updated" />
<liferay-ui:success key="purchaseTypeDeleted" message="purchase-type-deleted" />