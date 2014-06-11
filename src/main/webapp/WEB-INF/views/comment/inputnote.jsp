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
<title>知识学习和过程评价系统 - 我的学习笔记</title>
<jsp:include page="/WEB-INF/views/common/include-head.jsp"></jsp:include>
<script type="text/javascript"
	src="<%=basePath%>plguin/simditor/scripts/js/simditor-markdown.js"></script>
<script type="text/javascript">
	function sublearn(){
		document.getElementById("commentForm").action = "subLearnComment.action";
		document.getElementById("commentForm").submit();
	}
	
	function finishlearn(){
		document.getElementById("commentForm").action = "finishLearnComment.action";
		document.getElementById("commentForm").submit();
	}
</script>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/views/common/user-header.jsp"></jsp:include>
		<div id="contant" class="row">
			<div class="col-md-10 col-md-offset-1">
				<div id="describe">
					<div class="panel-body" id="form">
						<div class="row">
							<h3>
								<a><s:property value="model.generalPoint.pointName" />/
								<s:property value="dictionaryServices.findDictionary(2, model.generalPoint.pointType).getLabel()" /></a>
							</h3>
						</div>
					</div>
				</div>
				<hr />
				<div id="note" style="margin-bottom: 26px;">
					<h4>我的学习笔记：</h4>

					<form id="commentForm" action="subLearnComment.action" method="post">
						<input type="hidden" name="model.id" value="${model.id }">
						<input type="hidden" name="model.generalPoint.id" value="${model.generalPoint.id }">
						<textarea id="edit" name="model.note">${model.note }</textarea>
					</form>
					<script type="text/javascript">
						(function() {
						  $(function() {
						    return new Simditor({
						      textarea: $('#edit'),
						      placeholder: '',
						      mark:true
						    });
						  });
				
						}).call(this);
				
						</script>
				</div>
			</div>
			<div class="row">
				<div class="col-md-1 col-md-offset-8">
					<button id="btn-save" class="btn btn-primary btn-lg" onclick="sublearn();">保存</button>
					<script type="text/javascript">
						$("#btn-save").popover({
							placement: "left",
							content:"保存成功"
						});
					</script>
				</div>
				<div class="col-md-1">
					<button class="btn btn-warning btn-lg" data-toggle="modal"
						data-target="#completeNote">完成</button>
				</div>
				<div class="col-md-1">
					<button class="btn btn-default btn-lg">取消</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="completeNote" tabindex="-1" role="dialog"
		aria-labelledby="deleteLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="deleteLabel">Warning!</h4>
				</div>
				<div class="modal-body">确定完成意味着结束本知识点学习，完成学习？</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">继续学习</button>
					<button type="button" class="btn btn-primary" onclick="finishlearn();">确定完成</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal end -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>