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
		document.getElementById("listform").action = "deleteGPoint.action";
		document.getElementById("listform").submit();
	}
	function updateEntity(id) {
		document.getElementById("listform").key.value = id;
		document.getElementById("listform").action = "toinputGPoint.action";
		document.getElementById("listform").method = "post";
		document.getElementById("listform").submit();
	}
	function addEntity() {
		document.getElementById("listform").key.value = "";
		document.getElementById("listform").action = "toinputGPoint.action";
		document.getElementById("listform").submit();
	}
	function listDPoint(id) {
		document.getElementById("listform").key.value = id;
		document.getElementById("listform").action = "adminListDPoint.action";
		document.getElementById("listform").method = "post";
		document.getElementById("listform").submit();
	}
	
	$( document ).ready(function() {
		$("#compute").click(function () {
			$.ajax({
				url : "ComAndImportCompute.action",
				type : "post"
				});
		});
	});
</script>
</head>
<body>
	<div class="container">
		<div id="header">
			<jsp:include page="/WEB-INF/views/common/user-header.jsp"></jsp:include>
		</div>
		<div id="contant" style="margin-top:30px;">
			<div class="row">
				<div class="col-md-3">
					<ul class="nav nav-pills nav-stacked">
						<li class="active" id="side-nav"><a href="#">知识点管理</a></li>
						<li id="side-nav"><a onclick="addEntity()">添加</a></li>
						<li id="side-nav"><a id="compute">计算</a></li>
					</ul>
				</div>
				<div class="col-md-7 col-md-offset-1" id="main">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">知识点管理</h3>
						</div>
						
						<div class="panel-body">
						<!-- <a href="#" onclick="addEntity()">添加一个新的粗知识点</a> -->
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
											<td><a href="#" onclick="listDPoint('<s:property value="id"/>')">查看细知识点</a>
											/
											<a href="#" onclick="updateEntity('<s:property value="id"/>')">编辑</a>
											/
											<a href="#" onclick="deleteEntity('<s:property value="id"/>')">删除</a></td>
										</tr>
									</s:iterator>
								</table>
								<input id="key" type="hidden" name="key" />
							</form>
							<page:page url="/adminListGPoint.action" page="${page }" />
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