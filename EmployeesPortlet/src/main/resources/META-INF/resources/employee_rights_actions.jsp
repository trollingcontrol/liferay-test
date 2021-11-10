<%@ include file="init.jsp" %>

<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    EmployeeRight employeeRight = (EmployeeRight) row.getObject();

    String rightId = Long.toString(employeeRight.getRightId());
%>

<portlet:actionURL name="deleteRight" var="deleteRightURL">
    <portlet:param name="id" value="<%= String.valueOf(employeeRight.getEmployeeId()) %>" />
    <portlet:param name="mvcPath" value="/employee_rights.jsp" />
    <portlet:param name="employeeRightIdToBeDeleted" value="<%= rightId %>" />
</portlet:actionURL>

<aui:button-row>
    <aui:button value="Delete" onClick="<%= deleteRightURL %>" />
</aui:button-row>