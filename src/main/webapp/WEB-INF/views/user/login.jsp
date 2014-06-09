<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/include-head.jsp"></jsp:include>
</head>
<body>
	<div id="container" class="row">
		<div class="col-md-10 col-md-offset-1" style="margin: 50px 180px;">
			<div class="col-md-4" id="login">
				<h2>用户登录</h2>
				<form class="form-horizontal" role="form" action="loginUserAction.action" method="post">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-4 control-label">用户名：</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputEmail3"
								placeholder="用户名" style="box-shadow: 5px 5px 10px #e3e3e3;" name="model.username">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">密码：</label>
						<div class="col-md-8">
							<input type="password" class="form-control" id="inputPassword3"
								placeholder="密码" style="box-shadow: 5px 5px 10px #e3e3e3;" name="model.userpass">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-10">
							<button type="submit" class="btn btn-default"
								style="box-shadow: 5px 5px 10px #e3e3e3;">登录</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-1">
				<table border="0" cellpadding="0" cellspacing="0" align="center">
					<tr>
						<td width="200" style="BORDER-LEFT: #aaaaaa 2px solid">&nbsp;</td>
					</tr>
					<tr>
						<td width="200" style="BORDER-LEFT: #aaaaaa 2px solid">&nbsp;</td>
					</tr>
					<tr>
						<td width="200" style="BORDER-LEFT: #aaaaaa 2px solid">&nbsp;</td>
					</tr>
					<tr>
						<td width="200" style="BORDER-LEFT: #aaaaaa 2px solid">&nbsp;</td>
					</tr>
					<tr>
						<td width="200" style="BORDER-LEFT: #aaaaaa 2px solid">&nbsp;</td>
					</tr>
					<tr>
						<td width="200" style="BORDER-LEFT: #aaaaaa 2px solid">&nbsp;</td>
					</tr>
					<tr>
						<td width="200" style="BORDER-LEFT: #aaaaaa 2px solid">&nbsp;</td>
					</tr>
					<tr>
						<td width="200" style="BORDER-LEFT: #aaaaaa 2px solid">&nbsp;</td>
					</tr>
					<tr>
						<td width="200" style="BORDER-LEFT: #aaaaaa 2px solid">&nbsp;</td>
					</tr>
					<tr>
						<td width="200" style="BORDER-LEFT: #aaaaaa 2px solid">&nbsp;</td>
					</tr>
					<tr>
						<td width="200" style="BORDER-LEFT: #aaaaaa 2px solid">&nbsp;</td>
					</tr>
					<tr>
						<td width="200" style="BORDER-LEFT: #aaaaaa 2px solid">&nbsp;</td>
					</tr>
				</table>
			</div>
			<div class="col-md-4" id="register">
				<h2>用户注册</h2>
				<form class="form-horizontal" role="form" action="registerUserAction.action" method="post">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-4 control-label">用户名：</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputEmail3"
								placeholder="用户名" style="box-shadow: 5px 5px 10px #e3e3e3;" name="model.username">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">密码：</label>
						<div class="col-md-8">
							<input type="password" class="form-control" id="inputPassword3"
								placeholder="Password" style="box-shadow: 5px 5px 10px #e3e3e3;" name="model.userpass">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">确认密码：</label>
						<div class="col-md-8">
							<input type="password" class="form-control" id="inputPassword3"
								placeholder="Password" style="box-shadow: 5px 5px 10px #e3e3e3;">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default"
								style="box-shadow: 5px 5px 10px #e3e3e3;">注册</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>