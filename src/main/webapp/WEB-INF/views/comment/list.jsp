<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/include-head.jsp"></jsp:include>
<title>评论列表</title>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/views/common/user-header.jsp"></jsp:include>
		<div id="contant" style="margin-top: 26px;">
			<div class="row">
				<div class="col-md-3">
					<div class="panel-group" id="accordion">
						<button id="btn-define">知识点</button>
						<div class="panel panel-default" id="side-nav">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-toggle="collapse"
										data-parent="#accordion" href="#collapseOne"> C#<span
										class="caret"></span>
									</a>
								</h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse in">
								<div class="panel-body">
									<ul>
										<li><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
									</ul>
								</div>
							</div>
						</div>

						<div class="panel panel-default" id="side-nav">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-toggle="collapse"
										data-parent="#accordion" href="#collapseThree"> java<span
										class="caret"></span>
									</a>
								</h4>
							</div>
							<div id="collapseThree" class="panel-collapse collapse">
								<div class="panel-body"></div>
							</div>
						</div>

						<div class="panel panel-default" id="side-nav">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-toggle="collapse"
										data-parent="#accordion" href="#collapseThree"> UI<span
										class="caret"></span>
									</a>
								</h4>
							</div>
							<div id="collapseThree" class="panel-collapse collapse">
								<div class="panel-body"></div>
							</div>
						</div>

					</div>
				</div>
				<div class="col-md-7 col-md-offset-1" id="main">
					<div id="comment-cotainer">
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
							<div class="row" style="margin-bottom: 30px;">
								<div class="col-md-3 col-md-offset-2">
									难度值：<span class="glyphicon glyphicon-star"></span><span
										class="glyphicon glyphicon-star"></span><span
										class="glyphicon glyphicon-star"></span><span
										class="glyphicon glyphicon-star-empty"></span><span
										class="glyphicon glyphicon-star-empty"></span>
								</div>
								<div class="col-md-3">
									重要性：<span class="glyphicon glyphicon-star"></span><span
										class="glyphicon glyphicon-star"></span><span
										class="glyphicon glyphicon-star"></span><span
										class="glyphicon glyphicon-star-empty"></span><span
										class="glyphicon glyphicon-star-empty"></span>
								</div>
							</div>
							<!--    他人评论内容         -->
							
							<div id="comment">
							<s:iterator value="entities">
								<div class="panel panel-default" style="margin-top: 10px;">
									<div id="commet-item" class="row">
										<div class="panel-body">
											<div id="avater" class="col-md-2">
												<p><s:property value="user.username" /></p>
											</div>
											<div class="col-md-10">
												<p><s:property value="comment" /></p>
											</div>
										</div>
									</div>
									<div class="panel-footer">
										<div class="row">
											<div id="importance/difficulty" class="col-md-8">
											难度值：<s:property value="getLabel('complexity', complexity)"/>
											重要性: <s:property value="getLabel('importance', importance)"/>
											</div>
											<div id="comment-op" class="col-md-2 col-md-offset-1">
												<span id="comment-time">19:17</span> <a href="#">回复</a>
											</div>
										</div>
									</div>
								</div>
								</s:iterator>
							</div>
							<div id="pager" style="margin-left: 180px;">
								<ul class="pagination">
									<li><a href="#">&laquo;</a></li>
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#">&raquo;</a></li>
								</ul>
							</div>
							<hr style="margin-top: 0px;" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>