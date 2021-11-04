<%@ include file="init.jsp" %>

<portlet:renderURL var="addProductURL">
    <portlet:param name="mvcPath" value="/add_product.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editProductURL">
    <portlet:param name="mvcPath" value="/edit_product.jsp" />
</portlet:renderURL>

<aui:button-row>
    <aui:button onClick="<%= addProductURL %>" value="+" />
</aui:button-row>

<liferay-ui:search-container total="<%= ProductLocalServiceUtil.getProductsCount() %>">
    <liferay-ui:search-container-results
            results="<%= ProductLocalServiceUtil.getProducts(
				searchContainer.getStart(),
				searchContainer.getEnd()) 
			%>"
    />

    <liferay-ui:search-container-row
            className="com.trollingcont.servicebuilder.model.Product"
            modelVar="product">

        <liferay-ui:search-container-column-text property="productId" name="ID" />
        <liferay-ui:search-container-column-text property="name" name="Name" />
		<liferay-ui:search-container-column-text property="productTypeId" name="Type ID" />
		<liferay-ui:search-container-column-text property="cost" name="Cost" />
		<liferay-ui:search-container-column-text property="amount" name="Amount" />
		<liferay-ui:search-container-column-text property="present" name="Is present?" />
		<liferay-ui:search-container-column-text property="archived" name="Is archived?" />
		<liferay-ui:search-container-column-text property="description" name="Description" />
        <liferay-ui:search-container-column-jsp path="/product_actions.jsp" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

</liferay-ui:search-container>