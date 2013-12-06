<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
	<title><decorator:title default="Hallo"/></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<link href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
	<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
	<link rel="stylesheet" href="//cdn.leafletjs.com/leaflet-0.7/leaflet.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap-modal/css/bootstrap-modal-bs3patch.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap-modal/css/bootstrap-modal.css" />
	 <!--[if lte IE 8]>
	     <link rel="stylesheet" href="//cdn.leafletjs.com/leaflet-0.7/leaflet.ie.css" />
	 <![endif]-->
	<link href="${pageContext.request.contextPath}/styles/main.css" rel="stylesheet" type="text/css"/>
    <decorator:head/>
</head>
<body id="page-home">
    <decorator:body/>
    <!-- JavaScript -->
    <script data-main="${pageContext.request.contextPath}/js/app.js" src="${pageContext.request.contextPath}/lib/require.js"></script>
    <div id="ajax-modal" class="modal fade" tabindex="-1" style="display: none;"></div>
</body>
</html>
