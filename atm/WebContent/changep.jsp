<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码页</title>
</head>
<body>
	<form action="ChangePServlet" method="post">
		${info }<br>
		输入旧密码：<input type="password" name="oldpass"><br>
		输入新密码：<input type="password" name="newpass1"><br>
		输入新密码：<input type="password" name="newpass2"><br>
		<input type="submit" value="确定">
	</form>
	<input type="button" onclick="window.location.href='login.jsp';" value="重新登录">
</body>
</html>