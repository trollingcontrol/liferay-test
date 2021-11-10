<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.trollingcont.servicebuilder.model.Employee" %>
<%@ page import="com.trollingcont.servicebuilder.service.EmployeeLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.trollingcont.servicebuilder.model.EmployeeRight" %>
<%@ page import="com.trollingcont.servicebuilder.service.EmployeeRightLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="com.trollingcont.servicebuilder.service.ProductTypeLocalServiceUtil" %>
<%@ page import="com.trollingcont.servicebuilder.model.ProductType" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.trollingcont.servicebuilder.model.EmployeeRight" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.trollingcont.servicebuilder.model.Post" %>
<%@ page import="com.trollingcont.servicebuilder.service.PostLocalServiceUtil" %>
<%@ page import="com.trollingcont.servicebuilder.model.EmployeeRight" %>
<%@ page import="java.util.List" %>
<%@ page import="com.trollingcont.servicebuilder.service.EmployeeRightLocalServiceUtil" %>
<%@ page import="com.trollingcont.servicebuilder.service.persistence.EmployeeRightPersistence" %>
<%@ page import="javax.sound.sampled.Port" %>
<%@ page import="com.trollingcont.servicebuilder.model.ProductType" %>
<%@ page import="com.trollingcont.servicebuilder.service.ProductTypeLocalServiceUtil" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />