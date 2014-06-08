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
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/include-head.jsp"></jsp:include>
<script type="text/javascript"
	src="<%=basePath%>plguin/simditor/scripts/js/simditor-markdown.js"></script>
<script type="text/javascript">
	function sublearn(){
		document.getElementById("commentForm").action = "subLearnComment.action";
		document.getElementById("commentForm").submit();
	}
	
	function finishlearn(){
		document.getElementById("commentForm").action = "tofinishLearnComment.action";
		document.getElementById("commentForm").submit();
	}
</script>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/views/common/user-header.jsp"></jsp:include>
		<div id="contant" class="row">
			<div class="col-md-10 col-md-offset-1">
				<div id="describe">
					<div class="panel-body" id="form">
						<div class="row">
							<h3>
								<a><s:property value="model.generalPoint.pointName" />/
								<s:property value="dictionaryServices.findDictionary(2, model.generalPoint.pointType).getLabel()" /></a>
							</h3>
						</div>
					</div>
				</div>
				<hr />
				<div id="note" style="margin-bottom: 26px;">
					<h4>${model.user.userName } 的学习笔记：</h4>
					<div>${model.note }</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>