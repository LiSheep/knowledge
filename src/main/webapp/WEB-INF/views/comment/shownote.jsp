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
<title>知识学习和过程评价系统 - ${model.generalPoint.pointName }学习笔记</title>
<jsp:include page="/WEB-INF/views/common/include-head.jsp"></jsp:include>
<script type="text/javascript"
	src="<%=basePath%>plguin/simditor/scripts/js/simditor-markdown.js"></script>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/views/common/user-header.jsp"></jsp:include>
		<div id="contant" class="row">
			<div class="col-md-10 col-md-offset-1">
				<div id="describe">
					<div class="panel-body" id="form">
						<div class="row">
							<h2>
								<a><s:property value="model.generalPoint.pointName" />/
								<s:property value="dictionaryServices.findDictionary(2, model.generalPoint.pointType).getLabel()" /></a>
							</h2>
						</div>
					</div>
				</div>
				<hr />
				<h3>${model.user.username } 的学习笔记：</h3>
				<div id="note" style="margin-top: 50px; padding: 12px;border-radius:9px; border: 1.5px solid #428BCA; box-shadow:2px 2px 4px #2D687F; ">
					<div>${model.note }</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>