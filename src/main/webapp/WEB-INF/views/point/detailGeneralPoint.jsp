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
	function tolearn(id){
		window.location.href="toLearnComment.action?key=" + id;
	}
</script>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/views/common/user-header.jsp"></jsp:include>
		<div id="contant" class="row">
			<div class="row">
				<div class="col-md-11 col-md-offset-1" id="main" style="padding: 20px;">
					<h3><b><a>${model.pointName }</a></b></h3>
				<div class="row" id="knowpointhead" style="margin-bottom: 16px;">
					<div class="col-md-9" style="padding-left: 36px;">
						<a>${model.pointDescrible }</a>
					</div>
				</div>
				<div class="well">${model.pointDetail }</div>
				<div class="row" style="margin-bottom: 30px;">
					<div class="col-md-3 col-md-offset-2">
						难度值：
						<s:property
							value="dictionaryServices.findDictionary(4, model.complexity).getLabel()" />
					</div>
					<div class="col-md-3">
						重要性：
						<s:property
							value="dictionaryServices.findDictionary(4, model.importance).getLabel()" />
					</div>
					<div class="col-md-2">
						<button type="button" class="btn btn-success"
							style="float: right;" onclick="tolearn('${model.id}');">学习笔记</button>
					</div>
				</div>
				<hr />
				<div>
					<!--  tagCloud  -->
					<h4>具体细知识点</h4>
					<div class="row" id="myCanvasContainer"></div>

					<div id="tags">
						<ul>
							<li><a href="http://www.google.com" target="_blank"
								data-weight="17" style="font-size: 3.16ex">Google</a></li>
							<li><a href="/fish" data-weight="35"
								style="font-size: 2.16ex">Fish</a></li>
							<li><a href="/chips" data-weight="12"
								style="font-size: 1.16ex">Chips</a></li>
							<li><a href="/salt" data-weight="10"
								style="font-size: 5.16ex">Salt</a></li>
							<li><a href="/vinegar" data-weight="16"
								style="font-size: 6.33ex">Vinegar</a></li>
						</ul>
					</div>
				</div>
				<!--  tagCloud end  -->
			</div>
			</div>
		</div>
	</div>
</body>
</html>