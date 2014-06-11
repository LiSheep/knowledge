<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="header">
	<div class="row">
		<div class="col-md-4" style="margin-top: -10px; padding-left: 30px;">
			<img alt="" src="<%=basePath %>plguin/know/image/home-img.png">
		</div>
		<div class="col-md-6">
			<ul class="nav nav-pills nav-justified">
				<li class="active"><a id="main"
					href="<%=basePath %>loginUserAction.action">首页</a></li>
				<li><a href="#" id="knowledge">知识点</a></li>
				<li><a>您好 : <b>${session.user.username }</b></a></li>
				<!-- 
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul></li> -->
			</ul>
			<script>
				$(function(){
					$("#main").click(function () {
						unsetActive($("#main"));
					});
					$("#knowledge").click(function () {
						unsetActive($("#knowledge"));
					});
				});
			</script>
		</div>
	</div>
</div>
<!-- header end-->
