<%@ page import="com.trollingcont.bestemployees.portlet.BestEmployeeEntry" %>
<%@ page import="com.trollingcont.servicebuilder.model.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page errorPage="error.jsp" %>
<%@ include file="init.jsp" %>

<%
	HashMap<Post, List<BestEmployeeEntry>> bestEmployeesMap =
			(HashMap<Post, List<BestEmployeeEntry>>) request.getAttribute("bestEmployeesMap");

%>

<p>Best employees grouped by posts by summary cost of its purchases for last 30 days.</p>

<% if (bestEmployeesMap.size() == 0) { %>
<p>Nothing to show. There are no posts in system base.</p>
<% } %>

<div>
	<ul>
		<% for (Map.Entry<Post, List<BestEmployeeEntry>> entry : bestEmployeesMap.entrySet()) { %>
		<li>
			<p>Post: <%= entry.getKey().getName() %></p>
			<ul>
				<% if (entry.getValue().size() == 0) { %>
				<p>Nothing to show. There are no employees taking this post.</p>
				<% } %>
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