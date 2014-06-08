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
<script type="text/javascript">
	function toLearn() {
		document.getElementById("commentForm").submit();
	}
</script>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/views/common/user-header.jsp"></jsp:include>
		<div id="contant" style="margin-top: 26px;">
			<div class="row">
				<div class="col-md-3">
					<div class="panel-group" id="accordion" style="padding-top:60px">
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
					<form id="commentForm" action="detailGPoint.action" method="post">
						<input type="hidden" name="key" value="${model.generalPoint.id }">
						<div id="comment-cotainer">
							<div class="row panel-body" id="form" style="margin-top:-20px;">
								<h2>
									<a><s:property value="model.generalPoint.pointName" /></a>
									/
									<a><s:property value="dictionaryServices.findDictionary(2, model.generalPoint.pointType).getLabel()" /></a>
								</h2>
								<div class="well">
									<s:property value="model.generalPoint.pointDescrible" />
								</div>
							</div>
							<div class="row" style="margin-bottom: 30px;">
								<div class="col-md-3 col-md-offset-2">
									难度值：
									<s:property
										value="dictionaryServices.findDictionary(4, model.generalPoint.complexity).getLabel()" />
								</div>
								<div class="col-md-3">
									重要性：
									<s:property
										value="dictionaryServices.findDictionary(3, model.generalPoint.importance).getLabel()" />
								</div>
								<div class="col-md-2 col-md-offset-1">
									<button type="button" class="btn btn-success"
										style="float: right;" onclick="toLearn();">学习该知识点</button>
								</div>
							</div>
							<!--    他人评论内容         -->
							<div id="comment">
								<s:iterator value="entities">
									<div class="panel panel-default">
										<div id="commet-item" class="row">
											<div class="panel-body">
												<div id="avater" class="col-md-2">
													<p style="font-size:17px;">
														<b><a><s:property value="user.username" />：</a></b>
													</p>
												</div>
												<div class="col-md-10" >
													<p style="padding-top:5px; font-size: 16px">
														<s:property value="comment" />
													</p>
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
													<span id="comment-time"><s:date
															format="yyyy-MM-dd HH:mm:ss" name="updateTime" /> </span> <a
														href="showNoteComment.action?key=${id }">查看他的笔记<span
														class="caret"></span></a>
												</div>
											</div>
										</div>
									</div>
								</s:iterator>
							</div>
							<page:page
								url="/listGPointComment.action?key=${model.generalPoint.id }"
								page="${page }" />
							<hr style="margin-top: 0px;" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>