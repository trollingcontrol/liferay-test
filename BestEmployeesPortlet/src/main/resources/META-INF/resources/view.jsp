<%@ page errorPage="error.jsp" %>
<%@ include file="init.jsp" %>

<%
	HashMap<Post, List<BestEmployeeEntry>> bestEmployeesMap =
			(HashMap<Post, List<BestEmployeeEntry>>) request.getAttribute("bestEmployeesMap");

%>

<p>Best 3 or less employees grouped by posts by summary cost of its purchases for last 30 days.</p>
<p>
	Warning: if system can't retrieve cost of the product (possibly due to lack of it in base),
	it just skips that product, i.e. its cost becomes equal zero.
</p>

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
				<p>Nothing to show. There are no employees taking this post and/or purchases.</p>
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