<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>plguin/simditor/styles/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>plguin/simditor/styles/simditor.css" />
	<link rel="stylesheet" type="text/css" href="http://simditor.tower.im/assets/styles/app.css" />
	
	<script type="text/javascript" src="<%=basePath%>plguin/simditor/scripts/js/jquery.min.js"></script>
</head>
<body>
	<form method="post" action="addComment.action">
		<table>
		<tr>
			<td>复杂度</td><td><input name="complexity" /></td>
		</tr>
		<tr>
			<td>难度</td><td><input name="importance" /></td>
		</tr>
		<tr>	
			<td>笔记</td><td><textarea id="editor" name="comment" ></textarea></td>
		</tr>
		</table>
		
		<input type="submit"/>
		
	</form>
	<script type="text/javascript" src="<%=basePath%>plguin/simditor/scripts/js/simditor-all.min.js"></script>
	<script>
	(function() {
		  $(function() {
		    var editor;
		    return editor = new Simditor({
		      textarea: $('#editor'),
		      pasteImage: true,
		      toolbar: ['title', 'bold', 'italic', 'underline', 'strikethrough', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr', '|', 'indent', 'outdent'],
		    });
		  });
	}).call(this);
	</script>
</body>
</html>
