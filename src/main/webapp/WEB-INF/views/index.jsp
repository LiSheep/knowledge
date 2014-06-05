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
<title>Insert title here</title>
</head>
<body>
	<div class="row" style="margin-top: 5px; height: 500px">
		<div class="col-md-12" id="timeline-embed"></div>
		<script type="text/javascript">
			var timeline_config = {
				width : "100%",
				height : "100%",
				source : "<%=basePath%>json/<s:property value='id'/>.json"
			}
		</script>
		<script type="text/javascript" src="<%=basePath%>plguin/timeline/js/storyjs-embed.js"></script>
	</div>
</body>
</html>