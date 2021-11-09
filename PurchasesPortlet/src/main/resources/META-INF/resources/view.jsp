<%@ include file="init.jsp" %>

<portlet:renderURL var="addPurchaseURL">
	<portlet:param name="mvcPath" value="/add_purchase.jsp" />
</portlet:renderURL>

<aui:button-row>
	<aui:button onClick="<%= addPurchaseURL %>" value="+" />
</aui:button-row>

<liferay-ui:error key="invalidNumbers" message="invalid-numbers" />
<liferay-ui:error key="purchaseNotFound" message="purchase-not-found" />
<liferay-ui:error key="productNotFound" message="returned-product-not-found" />
<liferay-ui:error key="errorDeletingPurchase" message="error-deleting-purchase" />

<liferay-ui:search-container total="<%= PurchaseLocalServiceUtil.getPurchasesCount() %>">
	<liferay-ui:search-container-results
			results="<%= PurchaseLocalServiceUtil.getPurchases(
				searchContainer.getStart(),
				searchContainer.getEnd())
			%>"
	/>

	<liferay-ui:search-container-row
			className="com.trollingcont.servicebuilder.model.Purchase"
			modelVar="purchase">

		<%
			String productName;

			try {
				Product product = ProductLocalServiceUtil.getProduct(purchase.getProductId());
				productName = product.getName();
			}
			catch (PortalException pe) {
				productName = "[Can't get product name]";
			}

			String employeeName;

			try {
				Employee employee = EmployeeLocalServiceUtil.getEmployee(purchase.getEmployeeId());
				employeeName = String.format(
						"%s %s %s",
						employee.getLastName(),
						employee.getFirstName(),
						employee.getMiddleName()
				);
			}
			catch (PortalException pe) {
				employeeName = "[Can't get employee name]";
			}

			String purchaseTypeName;

			try {
				PurchaseType purchaseType = PurchaseTypeLocalServiceUtil.getPurchaseType(purchase.getPurchaseTypeId());
				purchaseTypeName = purchaseType.getName();
			}
			catch (PortalException pe) {
				purchaseTypeName = "[Can't get purchase type name]";
			}
		%>

		<liferay-ui:search-container-column-text property="purchaseId" name="Purchase ID" />
		<liferay-ui:search-container-column-text
				value='<%= String.format("%s (%d)", productName, purchase.getProductId()) %>'
				name="Product (ID)"
		/>
		<liferay-ui:search-container-column-text
				value='<%= String.format("%s (%d)", employeeName, purchase.getEmployeeId()) %>'
				name="Employee (ID)"
		/>
		<liferay-ui:search-container-column-date property="datePurchased" name="Date taken" />
		<liferay-ui:search-container-column-text
				value='<%= String.format("%s (%d)", purchaseTypeName, purchase.getPurchaseTypeId()) %>'
				name="Purchase type (ID)"
		/>
		<liferay-ui:search-container-column-jsp path="/purchase_actions.jsp" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>

<liferay-ui:success key="purchaseAdded" message="purchase-added" />
<liferay-ui:success key="purchaseDeleted" message="purchase-deleted" />