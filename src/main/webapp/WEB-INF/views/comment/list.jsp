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
										<a><s:property value="model.generalPoint.pointName"/>/<s:property value="dictionaryServices.findDictionary(2, model.generalPoint.pointType).getLabel()"/></a>
									</h3>
								</div>
								<div class="col-md-9">
									<div class="well">具体描述</div>
								</div>
							</div>
							<div class="row" style="margin-bottom: 30px;">
								<div class="col-md-3 col-md-offset-2">
									难度值：<s:property value="dictionaryServices.findDictionary(4, model.generalPoint.complexity).getLabel()"/>
								</div>
								<div class="col-md-3">
									重要性：<s:property value="dictionaryServices.findDictionary(3, model.generalPoint.importance).getLabel()"/>
								</div>
								<div class="col-md-2 col-md-offset-1">
							  		<button type="button" class="btn btn-success" style="float: right;">学习该知识点</button>
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
												<div id="importance/difficulty" class="col-md-7">
													难度值：
													<s:property
														value="dictionaryServices.findDictionary(4, complexity).getLabel()" />
													重要性:
													<s:property
														value="dictionaryServices.findDictionary(3, importance).getLabel()" />
												</div>
												<div id="comment-op" class="col-md-4 col-md-offset-1">
													<span id="comment-time">19:17</span>
													<a>查看他的笔记<span class="caret"></span></a>
												</div>
											</div>
										</div>
									</div>
								</s:iterator>
							</div>
							<page:page url="/listGPointComment.action" page="${page }" />
							<hr style="margin-top: 0px;" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>