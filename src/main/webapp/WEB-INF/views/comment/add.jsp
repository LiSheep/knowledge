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
<script type="text/javascript" src="<%=basePath%>know/js/simditor.js"></script>
<title>评论列表</title>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/views/common/user-header.jsp"></jsp:include>
		<div id="contant">
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
		具体描述
		<div class="row">
			<div class="col-md-3">
				<ul class="nav nav-pills nav-stacked">
					<li class="active" id="side-nav"><a href="#">知识点/粗知识点</a></li>
					<li id="side-nav"><a href="#">查看/编辑/删除</a></li>
					<li id="side-nav"><a href="#">添加</a></li>
					<li id="side-nav"><a>...</a></li>
					<li id="side-nav"><a>...</a></li>
				</ul>
			</div>
			<div class="col-md-7 col-md-offset-1" id="main">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">知识点体系/粗知识点</h3>
					</div>
					<div class="panel-body" id="form" style="padding: 16px;">
						<div class="row">
							<div class="col-md-2">
								<h3>
									<a>html/dom</a>
								</h3>
							</div>
							<div class="col-md-9">
								<div class="well">具体描述</div>
							</div>
						</div>
						<hr />
						<h4>我的评论：</h4>
						<form method="post" action="addComment.action">
							<div class="row" style="margin-bottom: 30px;">
								<div class="col-md-3 col-md-offset-2">
									难度值：
									<select class="form-control" name="model.complexity">
										<s:iterator var="type" value="#session.pointComplexity ">
											<option value="<s:property value="#type.code" />"><s:property value="#type.label" /></option>
										</s:iterator>
									</select>
								</div>
								<div class="col-md-3">
									重要性：
									<select class="form-control" name="model.importance">
										<s:iterator var="type" value="#session.pointImportance">
											<option value="<s:property value="#type.code" />"><s:property value="#type.label" /></option>
										</s:iterator>
									</select>
								</div>
							</div>
							<h5>知识评论</h5>
							<textarea class="form-control" name="comment" rows="3"></textarea>
							<h5>学习笔记</h5>
							<textarea id="note-editor" class="form-control" name="note"
								rows="3"></textarea>
							<script type="text/javascript">
								new_simditroy("note-editor");
							</script>
							<!-- 这里是不是应该包在一个div里？ -ltc 5.29 -->
							<div class="row" style="margin-top: 12px;">
								<div class="col-md-2 col-md-offset-2">
									<button type="submit" class="btn btn-primary">提交</button>
								</div>
								<div class="col-md-2 ">
									<button type="button" class="btn btn-primary">取消</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
