<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%> 
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<%=basePath%>plguin/bootstrap/css/bootstrap-theme.min.css" />
	<link rel="stylesheet" href="<%=basePath%>plguin/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="<%=basePath%>plguin/know/style/main.css" />
	
	<link rel="stylesheet" href="<%=basePath%>plguin/xcharts/xcharts.css" />
	<link rel="stylesheet" href="<%=basePath%>plguin/xcharts/master.css" />
	
	<link rel="stylesheet" href="<%=basePath%>plguin/simditor/styles/simditor.css" />
	<link rel="stylesheet" href="<%=basePath%>plguin/simditor/styles/font-awesome.css" />
	
	<script type="text/javascript" src="<%=basePath%>plguin/jquery/jquery-2.0.3.js" ></script>
	<script type="text/javascript" src="<%=basePath%>plguin/bootstrap/js/bootstrap.min.js" ></script>
	
	<script type="text/javascript" src="<%=basePath%>plguin/simditor/scripts/js/simditor-all.min.js" ></script>
	<script type="text/javascript" src="<%=basePath%>plguin/xcharts/d3.js" ></script>
	<script type="text/javascript" src="<%=basePath%>plguin/xcharts/rainbow.min.js" ></script>
	<script type="text/javascript" src="<%=basePath%>plguin/xcharts/xcharts.js" ></script>
	
	<script type="text/javascript" src="<%=basePath%>plguin/know/js/common.js" ></script>
	