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
<title>评论添加</title>
<jsp:include page="/WEB-INF/views/common/include-head.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/views/common/user-header.jsp"></jsp:include>
	</div>
	<div id="contant">
		<div class="row">
			<form action="submitComment.action" method="post">
				<input type="hidden" name="model.id" value="${model.id }"> <input
					type="hidden" name="model.generalPoint.id"
					value="${model.generalPoint.id }">
				<div class="col-md-11" id="main">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								知识点小结
							</h3>
						</div>
						<div class="panel-body" id="form" style="padding: 16px;">
							<div class="row">
								<div class="col-md-5  col-md-offset-1">
									<h3>
										<a><s:property value="model.generalPoint.pointName" />/ <s:property
										value="dictionaryServices.findDictionary(2, model.generalPoint.pointType).getLabel()" /></a>
									</h3>
								</div>
							</div>
							<hr />
							<h4>我的评论：</h4>
							<div class="row" style="margin-bottom: 30px;">
								<div class="col-md-3 col-md-offset-1">
									难度值：
									<s:select cssClass="form-control" name="model.complexity"
										list="#session.pointComplexity" listKey="code"
										listValue="label"></s:select>

								</div>
								<div class="col-md-3">
									重要性：
									<s:select cssClass="form-control" name="model.importance"
										list="#session.pointImportance" listKey="code"
										listValue="label"></s:select>
								</div>
							</div>
							
							<textarea class="form-control" rows="3" name="model.comment">${model.comment }</textarea>
							<div class="row" style="margin-top: 12px;">
								<div class="col-md-2 col-md-offset-2">
									<button type="submit" class="btn btn-primary">提交</button>
								</div>
								<div class="col-md-2 ">
									<button type="button" class="btn btn-primary">取消</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>