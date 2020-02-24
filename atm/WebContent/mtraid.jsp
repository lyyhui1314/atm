<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>转账账户页</title>
</head>
<body>
	<form action="MTraServlet" method="post">
		${info }<br>
		请输入转账账户：
		<input type="text" name="traid"><br>
		<input type="submit" value="确定">
	</form>
	<input type="submit" onclick="window.location.href='index.jsp';" value="返回主页面">
</body>
</html>