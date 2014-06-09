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
//不同选项卡的关联
$( document ).ready(function() {
	$("#net").click(function () {
		requestJson(4);
		
	});
	$("#java").click(function () {
		requestJson(1);
		
	});
	$("#linux").click(function () {
		requestJson(2);
		
	});
	$("#ui").click(function () {
		requestJson(6);
		
	});
	$("#c").click(function () {
		requestJson(7);
		
	});
	$("#database").click(function () {
		requestJson(5);
		
	});
});
</script>
</head>
<body>
	<div class="container" style="margin-top: 5px;">
		<div id="header">
			<div class="row">
				<div class="col-md-3">
					<h4>
						LOGO <span class="label label-default">New</span>
					</h4>
				</div>
				<div class="col-md-6 col-md-offset-1">
					<ul class="nav nav-pills nav-justified">
						<li class="active"><a href="<%=basePath %>loginUserAction.action">首页</a></li>
						<li><a href="#">知识点</a></li>
						<li><a>您好 : <b><s:property value="#session.user.username"/></b></a></li>
					</ul>
				</div>
			</div>
		</div>
		<div id="contant" style="margin-top: 10px;">
			<div class="row">
				<div class="col-md-3">
					<ul class="nav nav-pills nav-stacked" id="knowledgeSystem">
						<li class="active" id="side-nav"><a id="java">java</a></li>
						<li id="side-nav"><a id="net">.net</a></li>
						<li id="side-nav"><a id="ui">UI</a></li>
						<li id="side-nav"><a id="linux">Linux</a></li>
						<li id="side-nav"><a id="c">C</a></li>
						<li id="side-nav"><a id="database">Database</a></li>
					</ul>
				</div>
				<div class="col-md-7 col-md-offset-1" id="main">
					<div class="row guttered">
						<div class="span2" style="margin-top: 20px;">
							<figure id="mainChart" style="height: 320px; width: 700px;"></figure>
						</div>
						<script type="text/javascript">
						function requestJson(num) {
							var json = {
								"xScale" : "ordinal",
								"yScale" : "linear",
								"type" : "line-dotted",
								"comp" : [],
								"main" : []
							};
							
							if (typeof num == undefined)
								num = 1;

							reqImportance(function(err, data) {

								json.main[0] = data;

								reqComplexity(function(err, data) {
									json.main[1] = data;

									new xChart('line-dotted', json, '#mainChart', opts);
								}, num);

							}, num);
						}
						
							var tt = document.createElement('div'), leftOffset = -(~~$(
									'html').css('padding-left').replace('px',
									'') + ~~$('body').css('margin-left')
									.replace('px', '')), topOffset = -32;
							tt.className = 'ex-tooltip';

							document.body.appendChild(tt);

							var opts = {
								"axisPaddingTop" : 5,
								"mouseover" : function(d, i) {
									var pos = $(this).offset();
									$(tt).text(d.x + ': ' + d.y).css({
										top : topOffset + pos.top,
										left : pos.left + leftOffset
									}).show();
								},
								"mouseout" : function(x) {
									$(tt).hide();
								},
								"click" : function(d, i) {
									  window.location.href = "<%=basePath%>listGPointComment.action?key=" + d.id;
								}
							};
							
							requestJson(1);

							function reqImportance(cb, num) {
								$.ajax({
									url : "listByTypeImportanceJson.action",
									type : "post",
									data : {
										"model.pointType" : num
									},
									success : function(data) {
										var json = {
											"className" : ".pizza1",
											"data" : JSON.parse(data)
										}

										cb(0, json);
									}
								});
							}
							function reqComplexity(cb, num) {
								$.ajax({
									url : "listByTypeCompelxityJson.action",
									type : "post",
									data : {
										"model.pointType" : num
									},
									success : function(data) {
										var json = {
											"className" : ".pizza2",
											"data" : JSON.parse(data)
										}
										cb(0, json);
									}
								});
							}
						</script>
					</div>
				</div>
			</div>
			<div class="row" style="margin-top: 5px; height: 500px">
				<div class="col-md-12" id="timeline-embed"></div>
				<script type="text/javascript">
			var timeline_config = {
				width : "100%",
				height : "100%",
				source : "<%=basePath%>json/<s:property value='#session.user.id'/>.json"
					}
				</script>
				<script type="text/javascript"
					src="<%=basePath%>plguin/timeline/js/storyjs-embed.js"></script>
			</div>
		</div>
	</div>
</body>
</html>