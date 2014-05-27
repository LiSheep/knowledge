<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form class="form-horizontal" role="form" action="addDictionaryAction.action" method="post">
	  <div class="form-group">
	    <label for="inputFiledName" class="col-sm-2 control-label">fieldName</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="inputFiledName" placeholder="性别" name="model.fieldName">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputFiledCode" class="col-sm-2 control-label">fieldCode</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="inputFiledCode" placeholder="1" name="model.fieldCode">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputLabel" class="col-sm-2 control-label">Label</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="inputLabel" placeholder="1" name="model.label">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputCode" class="col-sm-2 control-label">Code</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="inputCode" placeholder="1" name="model.code">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">Sign in</button>
	    </div>
	  </div>
	</form>
</body>
</html>