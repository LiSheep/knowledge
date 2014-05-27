<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
    
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
<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-2.0.3.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap/js/bootstrap.js"></script>
<link href="<%=basePath %>/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>/js/bootstrap/css/bootstrap-theme.css" rel="stylesheet" type="text/css" />
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
							<li>
								<a href="#"  class="dropdown-toggle" data-toggle="dropdown">个人信息 <b class="caret"></b></a>
						          <ul class="dropdown-menu">
						            <li><a href="#">Action</a></li>
						            <li><a href="#">Another action</a></li>
						            <li><a href="#">Something else here</a></li>
						            <li class="divider"></li>
						            <li><a href="#">Separated link</a></li>
						          </ul>								
							</li>
						</ul>
					</div>
				</div>
			</div>
			
			<div id="contant" style="margin-top: 10px">
				<div class="row">
					<div class="col-md-3" >
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
							    <h3 class="panel-title">知识点编辑</h3>
							  </div>
							  <!-- node add form -->
							  <form action="addNodeAction.action" method="post">
								  <div class="panel-body" id="form" style="padding: 16px;">
								  	<div class="row">
								  		<div class="col-md-2">知识点名：</div>
								  		<div class="col-md-6"><input type="text" class="form-control" placeholder="title" name="model.knowName"></div>
								  	</div>
								  	<div class="row" style="margin-top: 12px;">
								  		<div class="col-md-2">所属体系：</div>
								  		<div class="col-md-6">
								  			<div class="btn-group">
											    <select class="form-control" name="model.knowType">
											    	<s:iterator var="type" value="#session.nodeType ">
											    		<option value="<s:property value="#type.code" />"><s:property value="#type.label" /></option>
											    	</s:iterator>
												</select>
											 </div>
								  		</div>
								  	</div>							  	
								  	<div class="row" style="margin-top: 12px;">
								  		<div class="col-md-2">描述：</div>
								  		<div class="col-md-6"><textarea class="form-control" rows="3" name="model.knowDescription"></textarea></div>
								  	</div>	
									<hr style="margin-top: 12px;margin-bottom: 12px;"/>
								  	<div class="row">
								  		<div class="col-md-2">难度值：</div>
								  		<div class="col-md-6">
											<div class="btn-group">
											    <select class="form-control" name="model.knowComplexity">
												  <s:iterator var="type" value="#session.nodeImportance ">
											    		<option value="<s:property value="#type.code" />"><s:property value="#type.label" /></option>
											    	</s:iterator>
												</select>
											 </div>						  			
								  		</div>
								  	</div>								
								  	<div class="row" style="margin-top: 12px;">
								  		<div class="col-md-2">重要性：</div>
								  		<div class="col-md-6">
											<div class="btn-group" style="top: px;">
											    <select class="form-control" name="model.knowImportance">
												  <s:iterator var="type" value="#session.nodeComplexity ">
											    		<option value="<s:property value="#type.code" />"><s:property value="#type.label" /></option>
											    	</s:iterator>
												</select>
											 </div>								  			
								  		</div>
								  	</div>	
								  	<div class="row" style="margin-top: 12px;">
								  		<div class="col-md-2 col-md-offset-2">
								  			<input type="submit" class="btn btn-primary">提交
								  		</div>
								  		<div class="col-md-2 "><button type="button" class="btn btn-primary">取消</button></div>
								  	</div>
								  </div>
							  </form>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row" style="border: solid 1px black;height: 180px;">
				<div class="col-md-12" id="timeline-embed"></div>
				<script type="text/javascript">
					var timeline_config = {
						width : "100%",
						height : "100%",
						source : 'example_json.json'
					}
				</script>
				<script type="text/javascript" src="<%=basePath %>timeline/js/storyjs-embed.js"></script>
			</div>
		</div>
	</body>
</html>