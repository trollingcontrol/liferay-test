<%@ include file="init.jsp" %>

<liferay-ui:search-container total="<%= ProductTypeLocalServiceUtil.getProductTypesCount() %>">
	<liferay-ui:search-container-results
			results="<%= ProductTypeLocalServiceUtil.getProductTypes(
                    searchContainer.getStart(), searchContainer.getEnd()
                    ) %>"
	/>

	<liferay-ui:search-container-row
			className="com.trollingcont.servicebuilder.model.ProductType"
			modelVar="productType">

		<liferay-ui:search-container-column-text property="productTypeId" name="ID" />
		<liferay-ui:search-container-column-text property="name" name="Name" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>