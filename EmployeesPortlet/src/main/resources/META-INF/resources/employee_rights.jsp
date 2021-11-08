<%@ page import="com.trollingcont.servicebuilder.model.EmployeeRight" %>
<%@ page import="com.trollingcont.servicebuilder.service.EmployeeRightLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="com.trollingcont.servicebuilder.service.ProductTypeLocalServiceUtil" %>
<%@ page import="com.trollingcont.servicebuilder.model.ProductType" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ include file="init.jsp" %>
<%@ page errorPage="error.jsp" %>

<%
    long id = ParamUtil.getLong(request, "id");

    List<EmployeeRight> employeeRightList =
            EmployeeRightLocalServiceUtil.getEmployeeRightsList(id);
%>

<p>
    Right list for employee ID <%= id %>
</p>

<portlet:renderURL var="addEmployeeRightURL">
    <portlet:param name="mvcPath" value="/add_employee_right.jsp" />
    <portlet:param name="id" value="<%= Long.toString(id) %>" />
</portlet:renderURL>

<aui:button-row>
    <aui:button onClick="<%= addEmployeeRightURL %>" value="+" />
</aui:button-row>

<liferay-ui:search-container total="<%= employeeRightList.size() %>">
    <liferay-ui:search-container-results
            results="<%= employeeRightList %>"
    />

    <liferay-ui:search-container-row
            className="com.trollingcont.servicebuilder.model.EmployeeRight"
            modelVar="employeeRight">

        <%
            String typeName;
            try {
                ProductType productType =
                        ProductTypeLocalServiceUtil.getProductType(employeeRight.getProductTypeId());
                typeName = productType.getName();
            }
            catch (PortalException pe) {
                typeName = "Can't find product name";
            }
        %>

        <liferay-ui:search-container-column-text value="<%= typeName %>" name="Type name" />
        <liferay-ui:search-container-column-text property="productTypeId" name="Type ID" />
        <liferay-ui:search-container-column-jsp path="/employee_rights_actions.jsp" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

</liferay-ui:search-container>

<liferay-ui:success key="rightAdded" message="right-added" />
<liferay-ui:success key="rightDeleted" message="right-deleted" />
<liferay-ui:error key="rightNotFound" message="right-not-found" />
<liferay-ui:error key="errorDeletingRight" message="error-deleting-right" />
