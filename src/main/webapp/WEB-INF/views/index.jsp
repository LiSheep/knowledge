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
</head>
<body>
	<div class="span5" style="margin-top: 100px;">
		<figure id="mainChart" style="height: 300px; width: 700px;"></figure>
	</div>
	<script type="text/javascript">
		var tt = document.createElement('div'), leftOffset = -(~~$('html').css(
				'padding-left').replace('px', '') + ~~$('body').css(
				'margin-left').replace('px', '')), topOffset = -32;
		tt.className = 'ex-tooltip';
		
		document.body.appendChild(tt);
		
		var opts = {
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
			"click" : function(x) {
				alert(x);
			}
		};
		var myChart;
		var json;
		(function requestJson() {
			json = {
					"xScale" : "ordinal",
					"yScale" : "linear",
					"comp": [],
					"main" : []
				};
			
			reqImportance(function (err, data) {
				
				json.main[0] = data;
				
				reqComplexity(function (err, data) {
					json.main[1] = data;
					
					myChart = new xChart('line-dotted', json, '#mainChart', opts);
				});
				
			});
		})();
		
		function reqImportance(cb) {
			$.ajax({
				url : "listByTypeImportanceJson.action",
				type : "post",
				data : {
					"model.pointType" : 1
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
		function reqComplexity(cb) {
			$.ajax({
				url : "listByTypeCompelxityJson.action",
				type : "post",
				data : {
					"model.pointType" : 1
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
	<div id="json"></div>
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
</body>
</html>