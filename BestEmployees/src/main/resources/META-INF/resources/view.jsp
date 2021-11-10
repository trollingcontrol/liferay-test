<%@ page import="com.trollingcont.bestemployees.portlet.BestEmployeeEntry" %>
<%@ page import="com.trollingcont.servicebuilder.model.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ include file="init.jsp" %>

<%
	HashMap<Post, List<BestEmployeeEntry>> bestEmployeesMap =
			(HashMap<Post, List<BestEmployeeEntry>>) request.getAttribute("bestEmployeesMap");

%>

<c:set var="employeesMap" value="<%= bestEmployeesMap.entrySet() %>" />

<div>
	<ul>
		<% for (Map.Entry<Post, List<BestEmployeeEntry>> entry : bestEmployeesMap.entrySet()) { %>
		<li>
			<p>Post: <%= entry.getKey().getName() %></p>
			<ul>
				<% for (BestEmployeeEntry employeeEntry : entry.getValue()) { %>
				<li><%= String.format(
						"%s %s %s - %.2f RUB",
						employeeEntry.getEmployee().getLastName(),
						employeeEntry.getEmployee().getFirstName(),
						employeeEntry.getEmployee().getMiddleName(),
						employeeEntry.getCost() / 100D
				) %>
				</li>
				<% } %>
			</ul>
			<% } %>
		</li>
	</ul>
</div>