<%@ include file="init.jsp" %>
<%@ page errorPage="error.jsp" %>  

<%
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    String id = ParamUtil.getString(request, "id");
	String firstName = ParamUtil.getString(request, "firstName");
	String lastName = ParamUtil.getString(request, "lastName");
    String middleName = ParamUtil.getString(request, "middleName");
    String birthDateStr = ParamUtil.getString(request, "birthDateStr");
    String postId = ParamUtil.getString(request, "postId");
    boolean sex = ParamUtil.getBoolean(request, "sex");

	String information;

    Date birthDate;
	Calendar birthDateCalendar;

	birthDate = dateFormat.parse(birthDateStr);

	birthDateCalendar = Calendar.getInstance();
	birthDateCalendar.setTime(birthDate);

    information = String.format(
            "Current employee data<br>ID: %s<br>Last name: %s<br>First name: %s<br>Middle name: %s<br>Birth date: %s<br>Post ID: %s<br>Sex: %s",
            id,
            lastName,
            firstName,
            middleName,
            birthDateStr,
            postId,
            sex ? "Female" : "Male"
    );
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="editEmployee" var="editEmployeeURL">
    <portlet:param name="id" value="<%= id %>" />
    <portlet:param name="firstName" value="<%= firstName %>" />
    <portlet:param name="lastName" value="<%= lastName %>" />
    <portlet:param name="middleName" value="<%= middleName %>" />
    <portlet:param name="postId" value="<%= postId %>" />
    <portlet:param name="sex" value="<%= Boolean.toString(sex) %>" />
    <portlet:param name="birthDateStr" value="<%= birthDateStr %>" />
</portlet:actionURL>

<p>
    <%= information %>
</p>
<aui:form action="<%= editEmployeeURL %>" name="<portlet:namespace />editEmployeeForm">

    <liferay-ui:error key="invalidDateFormat" message="invalid-date-format" />
    <liferay-ui:error key="invalidNumbers" message="invalid-numbers" />
    <liferay-ui:error key="invalidNames" message="invalid-names" />
    <liferay-ui:error key="employeeNotFound" message="employee-not-found" />
    <liferay-ui:error key="postNotFound" message="post-not-found" />
    <liferay-ui:error key="dateInFuture" message="date-in-future" />
    <liferay-ui:error key="errorUpdatingEmployee" message="error-updating-employee" />

    <aui:fieldset>
        <aui:input name="newLastName" value="<%= lastName %>" />
        <aui:input name="newFirstName" value="<%= firstName %>" />
        <aui:input name="newMiddleName" value="<%= middleName %>" />
        <aui:input name="newPostId" value="<%= postId %>" />
        <aui:input name="newBirthDate"
                   type="date"
                   value='<%= String.format(
                           "%d-%02d-%02d",
                           birthDateCalendar.get(Calendar.YEAR),
                           birthDateCalendar.get(Calendar.MONTH) + 1,
                           birthDateCalendar.get(Calendar.DAY_OF_MONTH)) %>'
        />
        <p>Sex:</p>
        <aui:input name="newSexGroup" type="radio" label="Male" value="<%= false %>" checked="<%= !sex %>" />
        <aui:input name="newSexGroup" type="radio" label="Female" value="<%= true %>" checked="<%= sex %>" />
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button type="cancel" onClick="<%= viewURL %>" />
    </aui:button-row>

</aui:form>