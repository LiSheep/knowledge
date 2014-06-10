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
<script type="text/javascript" src="<%=basePath%>plguin/tag/tagcanvas.js"></script>
<title>知识学习和过程评价系统 - ${model.pointName } 详细内容</title>
<script type="text/javascript">
	function tolearn(id){
		window.location.href="toLearnComment.action?key=" + id;
	}
	window.onload = function() {
        try {
          TagCanvas.Start('myCanvas','tags',{
            textColour: '#ff0000',
            outlineColour: 'green',
            reverse: true,
            depth: 0.8,
            maxSpeed: 0.05,
            weight: true,
            weightMode: "both"
          });
          var gradient = {
			 0:   'red',
			 0.5: 'orange',
			 1:   'rgba(0,0,0,0.1)'
			};
		TagCanvas.weightGradient = gradient;
		TagCanvas.interval = 20;
		TagCanvas.textFont = 'Impact,Arial Black,sans-serif';
		TagCanvas.textColour = '#00f';
		TagCanvas.textHeight = 25;
		TagCanvas.outlineThickness = 5;
		TagCanvas.minBrightness = 0.1;
		TagCanvas.depth = 0.92;
		TagCanvas.pulsateTo = 0.2;
		TagCanvas.pulsateTime = 0.75;
		TagCanvas.initial = [0.1,-0.1];
		TagCanvas.decel = 0.98;
		TagCanvas.reverse = true;
		TagCanvas.hideTags = false;
		TagCanvas.shadow = '#ccf';
		TagCanvas.shadowBlur = 3;
		TagCanvas.weightFrom = 'data-weight';
        } catch(e) {
          // something went wrong, hide the canvas container
          document.getElementById('myCanvasContainer').style.display = 'none';
        }
      };
</script>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/views/common/user-header.jsp"></jsp:include>
		<div id="contant" class="row">
			<div class="row">
				<div class="col-md-11 col-md-offset-1" id="main" style="padding: 20px;">
					<h2><b><a>${model.pointName }</a></b></h2>
				<div class="row" id="knowpointhead" style="margin-bottom: 16px;">
					<div class="col-md-12" style="margin-top:20px; padding-left: 36px;">
						<a class="well">${model.pointDescrible }</a>
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
							value="dictionaryServices.findDictionary(3, model.importance).getLabel()" />
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
					<canvas width="500" height="300" id="myCanvas">
				        <p>你的浏览器不支持该功能，请使用chrome或firefox浏览器！</p>
				     </canvas>
					<div id="tags">
						<ul>
							<s:iterator value="model.detailPoints">
								<li><a href="#" data-weight='${complexity + importance }' style='font-size:${importance}ex;'><s:property value="pointName" /></a></li>
							</s:iterator>
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