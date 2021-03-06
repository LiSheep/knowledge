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
<meta http-equiv="Expires" CONTENT="0">
<meta http-equiv="Cache-Control" CONTENT="no-cache">
<meta http-equiv="Pragma" CONTENT="no-cache">
<script type="text/javascript">
	(function() {
		$(function() {
			return new Simditor({
				textarea : $('#edit'),
				placeholder : '',
				mark : true
			});
		});

	}).call(this);
</script>
</head>
<body>
	<div class="container">
		<div id="header">
			<jsp:include page="/WEB-INF/views/common/user-header.jsp"></jsp:include>
		</div>
		<div id="contant" style="margin-top:30px">
			<div class="row">
				<div class="col-md-12" id="main">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">大知识点<s:if test="model.id == null">添加</s:if><s:elseif test="model.id != null">修改</s:elseif></h3>
						</div>

						<form method="post" action="subinputGPoint.action">
							<input type="hidden" name="model.id" value="${model.id }" >
							<div class="panel-body" id="form" style="padding: 16px;">
								<div class="row">
									<div class="col-md-2">知识点名：</div>
									<div class="col-md-9">
										<input type="text" class="form-control" name="model.pointName" value="${model.pointName }">
									</div>
								</div>
								<div class="row" style="margin-top: 12px;">
									<div class="col-md-2">所属体系：</div>
									<div class="col-md-9">
										<div class="btn-group">
											 <s:select cssClass="form-control" name="model.pointType" list="#session.pointType" listKey="code" listValue="label"></s:select>
										</div>
									</div>
								</div>
								<div class="row" style="margin-top: 12px;">
									<div class="col-md-2">学习顺序：</div>
									<div class="col-md-9">
										<input type="text" class="form-control" name="model.orderNum" value="${model.orderNum }">
									</div>
								</div>
								<div class="row" style="margin-top: 12px;">
									<div class="col-md-2">简短描述：</div>
									<div class="col-md-9">
										<textarea class="form-control" rows="3" name="model.pointDescrible">${model.pointDescrible }</textarea>
									</div>
								</div>
								<div class="row" style="margin-top: 12px;">
									<div class="col-md-2">详细描述：</div>
									<div class="col-md-9">
										<textarea class="form-control" id="edit" rows="3" name="pointDetail">${model.pointDetail }</textarea>
									</div>
								</div>
								<hr style="margin-top: 12px; margin-bottom: 12px;" />

								<h4>我的评论：</h4>
								<div class="row" style="margin-bottom: 30px;">
									<div class="col-md-3 col-md-offset-2">
										难度值： <s:select cssClass="form-control" name="model.complexity" list="#session.pointComplexity" listKey="code" listValue="label"></s:select>
										
									</div>
									<div class="col-md-3">
										重要性： <s:select cssClass="form-control" name="model.importance" list="#session.pointImportance" listKey="code" listValue="label"></s:select>
									</div>
								</div>

								<div class="row" style="margin-top: 12px;">
									<div class="col-md-3 col-md-offset-3">
										<button type="submit" class="btn btn-primary">提交</button>
									</div>
									<div class="col-md3 ">
										<button type="button" class="btn btn-primary">取消</button>
									</div>
								</div>

							</div>
						</form>
						<!-- **panel-body end** -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>