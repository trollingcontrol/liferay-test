<%@ page import="com.trollingcont.servicebuilder.service.PurchaseTypeLocalServiceUtil" %>
<%@ include file="init.jsp" %>

<portlet:renderURL var="addPurchaseTypeURL">
	<portlet:param name="mvcPath" value="/add_product_type.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editPurchaseTypeURL">
	<portlet:param name="mvcPath" value="/edit_product_type.jsp" />
</portlet:renderURL>

<aui:button-row>
	<aui:button onClick="<%= addPurchaseTypeURL %>" value="+" />
</aui:button-row>

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

<liferay-ui:success key="productNameNotChanged" message="product-type-name-not-changed" />
<liferay-ui:success key="productTypeAdded" message="product-type-added" />
<liferay-ui:success key="productTypeDeleted" message="product-type-deleted" />
<liferay-ui:success key="productTypeUpdated" message="product-type-updated" />