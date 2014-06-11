<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>知识学习和过程评价系统 用户登录</title>
<jsp:include page="/WEB-INF/views/common/include-head.jsp"></jsp:include>
<style>
#bg {
	border: 1px solid #C0C0C0;
	border-radius: 5px;
	box-shadow: 5px 5px 10px #e3e3e3;
	margin-top: 16px;
	padding: 20px 0;
	background: -webkit-gradient(linear, left top, left bottom, from(#F1F5F7),
		to(#fff));
}

#btn-sign {
	box-shadow: 5px 5px 10px #e3e3e3;
	border-radius: 20px;
	width: 100px;
	margin-top: 10px;
}
</style>
</head>
<body>
	<div id="container" class="row" style="margin-top: 50px;">
		<div class="row" id="header">
			<div class="col-md-8 col-md-offset-2">
				<img alt="知识学习和过程评价系统"
					src="<%=basePath %>plguin/know/image/welcome-login.png ">
			</div>
		</div>
		<div class="col-md-8 col-md-offset-2" id="bg">
			<div class="row">
				<div class="col-md-5" id="login"
					style="padding-left: 50px; padding-right: -10px;">
					<h3>登录你的账户</h3>
					<hr />
					<form class="form-horizontal" action="loginUserAction.action"
						role="form" style="margin-top: 26px;" method="post">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-4 control-label">用户名：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="inputEmail3"
									placeholder="用户名" style="box-shadow: 5px 5px 10px #e3e3e3;"
									name="model.username">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">密码：</label>
							<div class="col-md-8">
								<input type="password" class="form-control" id="inputPassword3"
									placeholder="密码" style="box-shadow: 5px 5px 10px #e3e3e3;"
									name="model.userpass">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-3 col-sm-offset-1">
								<button type="submit" class="btn btn-default"
									style="box-shadow: 5px 5px 10px #e3e3e3;">登录</button>
							</div>
							<div class="col-sm-8" style="color: red; padding-top: 10px">${myerrors.get("login") }</div>
						</div>
					</form>
				</div>
				<div class="col-md-1" style="margin-left: 30px;">
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
				<div class="col-md-5" id="register" style="padding-right: 46px;">
					<h3>创建新的账户</h3>
					<hr />
					<form class="form-horizontal" action="registerUserAction.action"
						role="form" style="margin-top: 26px;" method="post">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-5 control-label">用户名：</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="inputEmail3"
									placeholder="用户名" style="box-shadow: 5px 5px 10px #e3e3e3;"
									name="model.username">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-5 control-label">密码：</label>
							<div class="col-md-7">
								<input type="password" class="form-control" id="inputPassword3"
									placeholder="密码"
									style="box-shadow: 5px 5px 10px #e3e3e3;" name="model.userpass">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-5 control-label">确认密码：</label>
							<div class="col-md-7">
								<input type="password" class="form-control" id="inputPassword3"
									placeholder="密码"
									style="box-shadow: 5px 5px 10px #e3e3e3;">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-1 col-sm-4">
								<button type="submit" class="btn btn-default"
									style="box-shadow: 5px 5px 10px #e3e3e3;">注册</button>
							</div>
							<div class="col-sm-7" style="color: red; padding-top: 10px">${myerrors.get("register") }</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>