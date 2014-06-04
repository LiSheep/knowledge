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
</head>
<body>
	<div class="container">
		<div id="header">
			<jsp:include page="/WEB-INF/views/common/user-header.jsp"></jsp:include>
			<div class="row" id="search">
				<div class="col-md-3 col-md-offset-8">
					<span class="glyphicon glyphicon-search"></span>
					<div class="btn-group">
						<button type="button" class="btn btn-default dropdown-toggle"
							data-toggle="dropdown">
							知识体系 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">Dropdown link</a></li>
							<li><a href="#">Dropdown link</a></li>
						</ul>
					</div>
					<div class="btn-group">
						<button type="button" class="btn btn-default dropdown-toggle"
							data-toggle="dropdown">
							时间段 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">Dropdown link</a></li>
							<li><a href="#">Dropdown link</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="contant">
			<div class="row">
				<div class="col-md-3">
					<ul class="nav nav-pills nav-stacked">
						<li class="active" id="side-nav"><a href="#">知识点管理</a></li>
						<li id="side-nav"><a href="#">查看/编辑/删除</a></li>
						<li id="side-nav"><a href="#">添加</a></li>
						<li id="side-nav"><a>...</a></li>
						<li id="side-nav"><a>...</a></li>
					</ul>
				</div>
				<div class="col-md-7 col-md-offset-1" id="main">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">大知识点<s:if test="model.id == null">添加</s:if><s:elseif test="model.id != null">修改</s:elseif></h3>
						</div>

						<form method="post" action="subinputGPoint.action">
							<input type="hidden" name="model.id" value="${model.id }" >
							<div class="panel-body" id="form" style="padding: 16px;">
								<div class="row">
									<div class="col-md-2">知识点名：</div>
									<div class="col-md-6">
										<input type="text" class="form-control" name="model.pointName" value="${model.pointName }">
									</div>
								</div>
								<div class="row" style="margin-top: 12px;">
									<div class="col-md-2">所属体系：</div>
									<div class="col-md-6">
										<div class="btn-group">
											 <s:select cssClass="form-control" name="model.pointType" list="#session.pointType" listKey="code" listValue="label"></s:select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-2">学习顺序：</div>
									<div class="col-md-6">
										<input type="text" class="form-control" name="model.orderNum" value="${model.orderNum }">
									</div>
								</div>
								<div class="row" style="margin-top: 12px;">
									<div class="col-md-2">描述：</div>
									<div class="col-md-6">
										<textarea class="form-control" rows="3" name="model.pointDescrible">${model.pointDescrible }</textarea>
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
									<div class="col-md-2 col-md-offset-2">
										<button type="submit" class="btn btn-primary">提交</button>
									</div>
									<div class="col-md-2 ">
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
</body>
</html>