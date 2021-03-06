<%@ include file="init.jsp" %>

<portlet:renderURL var="addPostURL">
    <portlet:param name="mvcPath" value="/add_post.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editPostURL">
    <portlet:param name="mvcPath" value="/edit_post.jsp" />
</portlet:renderURL>

<aui:button-row>
    <aui:button onClick="<%= addPostURL %>" value="+" />
</aui:button-row>

<liferay-ui:search-container total="<%= PostLocalServiceUtil.getPostsCount() %>">
    <liferay-ui:search-container-results
            results="<%= PostLocalServiceUtil.getPosts(
                    searchContainer.getStart(), searchContainer.getEnd()
                    ) %>"
    />

    <liferay-ui:error key="errorDeletingPost" message="error-deleting-post" />

    <liferay-ui:search-container-row
            className="com.trollingcont.servicebuilder.model.Post"
            modelVar="post">

        <liferay-ui:search-container-column-text property="postId" name="ID" />
        <liferay-ui:search-container-column-text property="name" name="Name" />
        <liferay-ui:search-container-column-jsp path="/post_actions.jsp" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

</liferay-ui:search-container>

<liferay-ui:success key="postAdded" message="post-added" />
<liferay-ui:success key="postUpdated" message="post-updated" />
<liferay-ui:success key="postDeleted" message="post-deleted" />