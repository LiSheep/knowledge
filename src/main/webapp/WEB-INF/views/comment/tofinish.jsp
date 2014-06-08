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
</head>
<body>

	<form action="submitComment.action" method="post">
		<input type="hidden" name="model.id" value="${model.id }">
		<input type="hidden" name="model.generalPoint.id" value="${model.generalPoint.id }">
		<div class="row">
			评论： <input type="text" name="model.comment" value="${model.comment }" />
		</div>
		<div class="row">
			<div class="col-md-3 col-md-offset-2">
				难度值：
				<s:select cssClass="form-control" name="model.complexity"
					list="#session.pointComplexity" listKey="code" listValue="label"></s:select>

			</div>
			<div class="col-md-3">
				重要性：
				<s:select cssClass="form-control" name="model.importance"
					list="#session.pointImportance" listKey="code" listValue="label"></s:select>
			</div>
		</div>
		<div class="row">
			<input type="submit" value="提交">
		</div>
	</form>

</body>
</html>