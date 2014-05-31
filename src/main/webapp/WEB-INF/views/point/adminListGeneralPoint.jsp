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
<script type="text/javascript">
	function deleteEntity() {
		$("#listform").attr("action", "deleteGPoint.action");
		$("#listform").submit();
	}
	function updateEntity() {
		$("#listform").attr("action", "inputGPoint.action");
		$("#listform").submit();
	}
</script>
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
							知识体系<span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">Dropdown link</a></li>
							<li><a href="#">Dropdown link</a></li>
						</ul>
					</div>
					<div class="btn-group">
						<button type="button" class="btn btn-default dropdown-toggle"
							data-toggle="dropdown">
							时间段<span class="caret"></span>
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
							<h3 class="panel-title">知识点管理</h3>
						</div>
						<div class="panel-body">
							<form method="post" id="listform">
								<table class="table table-hover">
									<thead>
										<tr>
											<th></th>
											<th>知识点</th>
											<th>难度情况</th>
											<th>重要程度</th>
											<th>操作</th>
										</tr>
									</thead>
									<tr>
										<s:iterator>
											<td>1</td>
											<td><a href="#">html</a></td>
											<td></td>
											<td></td>
											<td><a href="#" onclick="deleteEntity()">编辑</a>/<a>删除</a></td>
											<input type="hidden" name="model.id" value="123" />
										</s:iterator>
									</tr>
								</table>
							</form>
						</div>
					</div>
					<!--   panel end  -->
				</div>
			</div>
		</div>
		<!--  contant end  -->
	</div>
</body>
</html>