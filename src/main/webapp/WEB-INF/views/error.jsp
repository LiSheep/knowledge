<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/include-head.jsp"></jsp:include>
<title>对不起，没有找到您所输入的页面</title>
</head>
<body>
<body
	style="text-align:center; padding:0; margin:0; background:black url(<%=basePath%>plguin/know/image/404.jpg) top center no-repeat; height:100%; ">
	<a href="<%=basePath%>" onclick="javascript:history.go(-1);"
		style="display: block; width: 100%; height: 100%; min-height: 600px;">&nbsp;
	</a>
</body>
</html>