<%@ include file="init.jsp" %>

<portlet:renderURL var="addEmployeeURL">
    <portlet:param name="mvcPath" value="/add_employee.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editEmployeeURL">
    <portlet:param name="mvcPath" value="/edit_employee.jsp" />
</portlet:renderURL>

<aui:button-row>
    <aui:button onClick="<%= addEmployeeURL %>" value="+" />
</aui:button-row>

<liferay-ui:error key="invalidNumbers" message="invalid-numbers" />
<liferay-ui:error key="employeeNotFound" message="employee-not-found" />
<liferay-ui:error key="errorDeletingEmployee" message="error-deleting-employee" />

<liferay-ui:search-container total="<%= EmployeeLocalServiceUtil.getEmployeesCount() %>">
    <liferay-ui:search-container-results
            results="<%= EmployeeLocalServiceUtil.getEmployees(
				searchContainer.getStart(),
				searchContainer.getEnd()) 
			%>"
    />

    <liferay-ui:search-container-row
            className="com.trollingcont.servicebuilder.model.Employee"
            modelVar="employee">

        <%
            String postName;
            try {
                Post post = PostLocalServiceUtil.getPost(employee.getPostId());
                postName = post.getName();
            }
            catch (PortalException pe) {
                postName = "[Can't find post name]";
            }

            StringBuilder rightsList;

            List<EmployeeRight> employeeRightList =
                    EmployeeRightLocalServiceUtil.getEmployeeRightsList(employee.getEmployeeId());

            rightsList = new StringBuilder();

            for (EmployeeRight right : employeeRightList) {
                String productTypeName;

                try {
                    ProductType productType = ProductTypeLocalServiceUtil.getProductType(right.getProductTypeId());
                    productTypeName = productType.getName();
                }
                catch (PortalException pe) {
                    productTypeName = "[Can't find type name]";
                }

                rightsList.append(String.format("<p>%s (%d)</p>", productTypeName, right.getProductTypeId()));
            }
        %>

        <liferay-ui:search-container-column-text property="employeeId" name="ID" />
        <liferay-ui:search-container-column-text property="lastName" name="Last name" />
        <liferay-ui:search-container-column-text property="firstName" name="First name" />
		<liferay-ui:search-container-column-text property="middleName" name="Middle name" />
		<liferay-ui:search-container-column-date property="birthDate" name="Birth date" />
		<liferay-ui:search-container-column-text
                value='<%= String.format("%s (%d)", postName, employee.getPostId()) %>'
                name="Post (post ID)"
        />
		<liferay-ui:search-container-column-text value='<%= employee.getSex() ? "Female" : "Male" %>' name="Sex" />
        <liferay-ui:search-container-column-text value='<%= rightsList.toString() %>' name="Allowed product types (type (type ID))" />
        <liferay-ui:search-container-column-jsp path="/employee_actions.jsp" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

</liferay-ui:search-container>

<liferay-ui:success key="employeeAdded" message="employee-added" />
<liferay-ui:success key="employeeUpdated" message="employee-updated" />
<liferay-ui:success key="employeeDeleted" message="employee-deleted" />