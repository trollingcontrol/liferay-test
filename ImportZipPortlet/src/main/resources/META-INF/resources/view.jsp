<%@ page import="com.trollingcont.importziportlet.portlet.ZipImportResult" %>
<%@ include file="init.jsp" %>

<portlet:actionURL name="importZip" var="importZipURL" />

<%
	String importResultStr;

	ZipImportResult zipImportResult = (ZipImportResult) request.getAttribute("importResult");

	if (zipImportResult != null) {
		StringBuilder resultStr = new StringBuilder();

		for (ZipImportResult.ResultEntry resultEntry : zipImportResult.getResultEntries()) {
			resultStr.append(
					String.format(
							"<li>%s - %d entries, %d skipped</li>",
							resultEntry.getEntryName(),
							resultEntry.getTotalEntriesAmount(),
							resultEntry.getSkippedEntries()
					)
			);
		}

		if (zipImportResult.getResultEntries().size() > 0) {
			importResultStr = String.format("ZIP import result: <ul>%s</ul>", resultStr);
		}
		else {
			importResultStr = "Nothing to import in this ZIP archive";
		}
	}
	else {
		importResultStr = "";
	}
%>

<liferay-ui:error key="fileNotSelected" message="file-not-selected" />
<liferay-ui:error key="failedToOpenZip" message="failed-to-open-zip" />
<liferay-ui:error key="errorReadingZip" message="error-reading-zip" />

<div>
	<p>Select ZIP archive to import data to system</p>
	<aui:form id="uploadForm" action="<%= importZipURL %>" enctype="multipart/form-data" name="<portlet:namespace />importZipForm" method="post">
		<input type="file" name="zipFile" />
		<input type="submit" />
	</aui:form>
</div>

<div style="color: #008000"><%= importResultStr %></div>

<div>
	<p>File format: ZIP archive with CSV files in root directory.</p>
	<p>Files read by system (some files from this list might be missing, in this case they're just skipped):</p>
	<ul>
		<li>
			<p>Posts.csv</p>
			<p>Describes entries in Employee posts table</p>
			<p>Format: [ID],[name]</p>
		</li>
		<li>
			<p>ProductTypes.csv</p>
			<p>Describes entries in Product types table</p>
			<p>Format: [ID],[name]</p>
		</li>
		<li>
			<p>PurchaseTypes.csv</p>
			<p>Describes entries in Purchase types table</p>
			<p>Format: [ID],[name]</p>
		</li>
		<li>
			<p>Employees.csv</p>
			<p>Describes entries in Employees table</p>
			<p>Format: [ID],[Last name],[First name],[Middle name],[Birth date],[Post ID],[Sex]</p>
			<p>Birth date format: yyyy-MM-dd, i.e. 1998-05-29</p>
			<p>Sex format: true for female, false for male</p>
		</li>
		<li>
			<p>Products.csv</p>
			<p>Describes entries in Products table</p>
			<p>Format: [ID],[name],[product type ID],[cost],[amount],[is present],[is archived],[description]</p>
			<p>cost represents amount in pennies</p>
			<p>is present, is archived - boolean values (true/false)</p>
		</li>
		<li>
			<p>Purchases.csv</p>
			<p>Describes entries in Purchases table</p>
			<p>Format: [ID],[product ID],[employee ID],[purchase time],[purchase type ID]</p>
			<p>Purchase time format: yyyy-MM-dd'T'HH:mm:ss, i.e. 2001-07-04T12:08:56</p>
		</li>
	</ul>
</div>