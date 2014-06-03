<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/include-head.jsp"></jsp:include>
<title>Register</title>
</head>
<body>
	<form class="form-horizontal" role="form" action="registerUserAction.action" method="post">
	  <div class="form-group">
	    <label for="inputUsername" class="col-sm-2 control-label">Username</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="inputUsername" placeholder="Username" name="model.username">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputUserpass" class="col-sm-2 control-label">Password</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="inputUserpass" placeholder="Password" name="model.userpass">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputUserpass" class="col-sm-2 control-label">Password</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="inputUserrepass" placeholder="Password">
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