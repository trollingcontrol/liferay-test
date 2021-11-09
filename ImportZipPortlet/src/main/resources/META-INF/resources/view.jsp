<%@ page import="com.trollingcont.importziportlet.portlet.ZipImportResult" %>
<%@ include file="init.jsp" %>

<portlet:actionURL name="importZip" var="importZipURL" />

<p>Select ZIP archive to import data to system</p>

<aui:form id="uploadForm" action="<%= importZipURL %>" enctype="multipart/form-data" name="<portlet:namespace />importZipForm" method="post">
	<input type="file" name="zipFile" />
	<input type="submit" />
</aui:form>

<%
	String importResultStr;

	ZipImportResult zipImportResult = (ZipImportResult) request.getAttribute("importResult");

	if (zipImportResult != null) {
		importResultStr = "RESULT";
	}
	else {
		importResultStr = "NONE";
	}
%>

<p><%= importResultStr %></p>

<p>File format: ZIP archive with CSV files in root directory.</p>
<p>Files read by system (some files from this list might be missing, in this case they're just skipped):</p>
<ul>
	<li>
		<p>Posts.csv</p>
		<p>Matches list of employee posts</p>
		<p>Format: [ID],[name]</p>
	</li>
	<li>
		<p>ProductTypes.csv</p>
		<p>Matches list of product types</p>
		<p>Format: [ID],[name]</p>
	</li>
	<li>
		<p>PurchaseTypes.csv</p>
		<p>Matches list of purchase types</p>
		<p>Format: [ID],[name]</p>
	</li>
	<li>
		<p>PurchaseTypes.csv</p>
		<p>Matches list of purchase types</p>
		<p>Format: [ID],[name]</p>
	</li>
	<li>
		<p>Employees.csv</p>
		<p>Matches list of employees</p>
		<p>Format: [ID],[Last name],[First name],[Middle name],[Birth date],[Post ID],[Sex]</p>
		<p>Birth date format: yyyy-MM-dd, i.e. 1998-05-29</p>
		<p>Sex format: true for female, false for male</p>
	</li>
	<li>
		<p>Products.csv</p>
		<p>Matches list of products</p>
		<p>Format: [ID],[name],[product type ID],[cost],[amount],[is present],[is archived],[description]</p>
		<p>cost represents amount in pennies</p>
		<p>is present, is archived - boolean values (true/false)</p>
	</li>
	<li>
		<p>Purchases.csv</p>
		<p>Matches list of purchases</p>
		<p>Format: [ID],[product ID],[employee ID],[purchase time],[purchase type ID]</p>
		<p>Purchase time format: yyyy-MM-dd'T'HH:mm:ss.SSSXXX, i.e. 2001-07-04T12:08:56.235-07:00</p>
	</li>
</ul>