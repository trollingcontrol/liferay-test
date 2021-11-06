<%@ include file="init.jsp" %>

<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Post post = (Post) row.getObject();

	String id = Long.toString(post.getPostId());
	String name = post.getName();
%>

<portlet:actionURL name="deletePost" var="deletePostURL">
    <portlet:param name="postIdToBeDeleted" value="<%= id %>" />
</portlet:actionURL>

<portlet:renderURL var="editPostURL">
    <portlet:param name="mvcPath" value="/edit_post.jsp" />
    <portlet:param name="id" value="<%= id %>" />
    <portlet:param name="name" value="<%= name %>" />
</portlet:renderURL>

<aui:button-row>
    <aui:button value="Delete" onClick="<%= deletePostURL %>" />
    <aui:button value="Edit" onClick="<%= editPostURL %>" />
</aui:button-row>