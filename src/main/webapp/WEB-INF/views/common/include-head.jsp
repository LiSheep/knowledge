<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<%=basePath%>plguin/bootstrap/css/bootstrap-theme.min.css" />
	<link rel="stylesheet" href="<%=basePath%>plguin/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="<%=basePath%>know/style/main.css" />
	
	<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-2.1.0.js" ></script>
	<script type="text/javascript" src="<%=basePath%>js/bootstrap/js/bootstrap.min.js" ></script>
