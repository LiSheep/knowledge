<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/include-head.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div id="header">
			<div class="row">
				<center class="col-md-3">
					<h4>LOGO <span class="label label-default">New</span></h4>
				</center>
				<div class="col-md-7 col-md-offset-1">
					<ul class="nav nav-pills nav-justified">
						<li><a href="#">首页</a></li>
						<li><a href="#">知识点</a></li>
						<li class="active"><a href="#">管理</a></li>
						<li><a href="#" class="dropdown-toggle" data-toggle="dropdown">个人信息 <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
			<div class="row" id="search">
				<div class="col-md-3 col-md-offset-8">
					<span class="glyphicon glyphicon-search"></span>
					<div class="btn-group">
						<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
							知识体系 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">Dropdown link</a></li>
							<li><a href="#">Dropdown link</a></li>
						</ul>
					</div>
					<div class="btn-group">
						<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
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
					<div class="panel panel-primary" style="height: 400px;">
						<div class="panel-heading">
							<h3 class="panel-title">知识点管理</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover">
								<thead>
									<tr>
										<th></th>
										<th>知识点</th>
										<th>知识体系</th>
										<th>难度情况</th>
										<th>重要程度</th>
										<th>操作</th>
									</tr>
								</thead>
								<tr>
									<td>1</td>
									<td><a href="#">html</a></td>
									<td><a href="#">UI</a></td>
									<td>
										<span class="glyphicon glyphicon-star"></span> 
										<span class="glyphicon glyphicon-star"></span>
									</td>
									<td>
										<span class="glyphicon glyphicon-star"></span> 
										<span class="glyphicon glyphicon-star"></span></td>
									<td><a href="#">编辑</a>
										<button class="btn btn-warning btn-sm" data-toggle="modal" data-target="#deleteNode">delete</button></td>
								</tr>
								<tr>
									<td>2</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>3</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row" style="margin-top: 5px; height: 500px">
			<div class="col-md-12" id="timeline-embed"></div>
			<script type="text/javascript">
					var timeline_config = {
						width : "100%",
						height : "100%",
						source : '<%=basePath %>example_json.json'
					}
				</script>
			<script type="text/javascript" src="<%=basePath %>js/timeline/js/storyjs-embed.js"></script>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="deleteNode" tabindex="-1" role="dialog" aria-labelledby="deleteLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="deleteLabel">delete node</h4>
				</div>
				<div class="modal-body">are you sure delete this node ?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>