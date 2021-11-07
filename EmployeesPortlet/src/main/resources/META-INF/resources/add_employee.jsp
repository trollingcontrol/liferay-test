<%@ include file="init.jsp" %>

<%
    Calendar currentDate = Calendar.getInstance();
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addEmployee" var="addEmployeeURL" />

<aui:form action="<%= addEmployeeURL %>" name="<portlet:namespace />addEmployeeForm">
    <aui:fieldset>
        <aui:input name="firstName" />
        <aui:input name="lastName" />
        <aui:input name="middleName" />
        <aui:input name="postId" />
        <p>Birth date</p>
        <liferay-ui:input-date
            name="birthDate"
            formName="addEmployeeForm"
            dayValue="<%= currentDate.get(Calendar.DAY_OF_MONTH) %>"
            monthValue="<%= currentDate.get(Calendar.MONTH) %>"
            yearValue="<%= currentDate.get(Calendar.YEAR)  %>"
            lastEnabledDate="<%= currentDate.getTime() %>"
        />
        <p>Sex:</p>
        <aui:input name="sexGroup" type="radio" label="Male" value="<%= false %>" checked="<%= true %>" />
        <aui:input name="sexGroup" type="radio" label="Female" value="<%= true %>" />
    </aui:fieldset>

    <liferay-ui:error key="invalidDateFormat" message="invalid-date-format" />
    <liferay-ui:error key="invalidNumbers" message="invalid-numbers" />
    <liferay-ui:error key="invalidNames" message="invalid-names" />
    <liferay-ui:error key="postNotFound" message="post-not-found" />
    <liferay-ui:error key="errorAddingEmployee" message="error-adding-employee" />

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button type="cancel" onClick="<%= viewURL %>" />
    </aui:button-row>
</aui:form>