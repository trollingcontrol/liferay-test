<%@ include file="init.jsp" %>

<%
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Employee employee = (Employee) row.getObject();

	String id = Long.toString(employee.getEmployeeId());
	String firstName = employee.getFirstName();
	String lastName = employee.getLastName();
	String middleName = employee.getMiddleName();
	String birthDateStr = dateFormat.format(employee.getBirthDate());
	String postId = Long.toString(employee.getPostId());
	boolean sex = employee.getSex();
%>

<portlet:actionURL name="deleteEmployee" var="deleteEmployeeURL">
	<portlet:param name="employeeIdToBeDeleted" value="<%= id %>" />
</portlet:actionURL>

<portlet:renderURL var="editEmployeeURL">
    <portlet:param name="mvcPath" value="/edit_employee.jsp" />
	<portlet:param name="id" value="<%= id %>" />
	<portlet:param name="firstName" value="<%= firstName %>" />
	<portlet:param name="lastName" value="<%= lastName %>" />
	<portlet:param name="middleName" value="<%= middleName %>" />
	<portlet:param name="birthDateStr" value="<%= birthDateStr %>" />
	<portlet:param name="postId" value="<%= postId %>" />
	<portlet:param name="sex" value="<%= sex ? "True" : "False" %>" />
</portlet:renderURL>

<aui:button-row>
    <aui:button value="Delete" onClick="<%= deleteEmployeeURL %>" />
    <aui:button value="Edit" onClick="<%= editEmployeeURL %>" />
</aui:button-row>