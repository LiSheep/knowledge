<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="page" uri="/pagerTag"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/include-head.jsp"></jsp:include>
<title>Insert title here</title>
<script type="text/javascript">
function deleteEntity(id) {
	document.getElementById("listform").key.value = id;
	document.getElementById("listform").action = "deleteDPoint.action";
	document.getElementById("listform").submit();
}
function updateEntity(id) {
	document.getElementById("listform").key.value = id;
	document.getElementById("listform").action = "updateInputDPoint.action";
	document.getElementById("listform").method = "post";
	document.getElementById("listform").submit();
}
function addEntity() {
	document.getElementById("listform").key.value = '<s:property value="model.generalPoint.id"/>';
	document.getElementById("listform").action = "addInputDPoint.action";
	document.getElementById("listform").submit();
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
							<h3 class="panel-title"><s:property value="model.generalPoint.PointName"/> 细知识点管理</h3>
						</div>
						<div class="panel-body">
						<a href="#" onclick="addEntity()"> 添加一个新的细知识点</a>
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
									<s:iterator value="entities" status="L">
										<tr>
											<td><s:property value="#L.index+1" /></td>
											<td><a href="#"><s:property value="pointName" /></a></td>
											<td><s:property value="dictionaryServices.findDictionary(4, complexity).getLabel()" /></td>
											<td><s:property value="dictionaryServices.findDictionary(3, importance).getLabel()" /></td>
											<td><a href="#" onclick="updateEntity('<s:property value="id"/>')">编辑</a>
											/
											<a href="#" onclick="deleteEntity('<s:property value="id"/>')">删除</a></td>
										</tr>
									</s:iterator>
								</table>
								<input id="key" type="hidden" name="key" />
							</form>
							<div class="row">
								<div class="col-md-12">
									<page:page url="/adminListDPoint.action" page="${page }" />
								</div>
							</div>
							
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