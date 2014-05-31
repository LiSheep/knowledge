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
							<h3 class="panel-title">细知识点添加</h3>
						</div>

						<form method="post" action="addDPoint.action">
							<hidden name="model.generalKey" />
							<div class="panel-body" id="form" style="padding: 16px;">
								<div class="row">
									<div class="col-md-2">知识点名：</div>
									<div class="col-md-6">
										<input type="text" class="form-control" name="model.pointName">
									</div>
								</div>
								
								<div class="row" style="margin-top: 12px;">
									<div class="col-md-2">描述：</div>
									<div class="col-md-6">
										<textarea class="form-control" rows="3"></textarea>
									</div>
								</div>
								<hr style="margin-top: 12px; margin-bottom: 12px;" />

								<h4>我的评论：</h4>
								<div class="row" style="margin-bottom: 30px;">
									<div class="col-md-3 col-md-offset-2">
										难度值： <select class="form-control" name="model.complexity">
											<s:iterator var="type" value="#session.pointComplexity ">
												<option value="<s:property value="#type.code" />"><s:property
														value="#type.label" /></option>
											</s:iterator>
										</select>
									</div>
									<div class="col-md-3">
										重要性： <select class="form-control" name="model.importance">
											<s:iterator var="type" value="#session.pointImportance">
												<option value="<s:property value="#type.code" />"><s:property
														value="#type.label" /></option>
											</s:iterator>
										</select>
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