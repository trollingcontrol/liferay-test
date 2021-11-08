<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.trollingcont.servicebuilder.service.PurchaseLocalServiceUtil" %>
<%@ page import="com.trollingcont.servicebuilder.service.ProductLocalServiceUtil" %>
<%@ page import="com.trollingcont.servicebuilder.model.Product" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.trollingcont.servicebuilder.model.Employee" %>
<%@ page import="com.trollingcont.servicebuilder.service.EmployeeLocalServiceUtil" %>
<%@ page import="com.trollingcont.servicebuilder.model.Purchase" %>
<%@ page import="com.trollingcont.servicebuilder.model.PurchaseType" %>
<%@ page import="com.trollingcont.servicebuilder.service.PurchaseTypeLocalServiceUtil" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />