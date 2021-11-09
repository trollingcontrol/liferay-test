<%@ include file="init.jsp" %>

<portlet:actionURL name="importZip" var="importZipURL" />

<p>Select ZIP archive to import data to system</p>

<aui:form id="uploadForm" action="<%= importZipURL %>" enctype="multipart/form-data" name="<portlet:namespace />importZipForm" method="post">
	<input type="file" name="zipFile" />
	<input type="submit" />
</aui:form>