<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询页</title>
</head>
<body>
	您的余额为：${info }<br>
	<input type="button" onclick="window.location.href='mred.jsp';" value="取款">
	<input type="button"  onclick="window.location.href='mtraid.jsp';" value="转账"><br>
	<input type="button"  onclick="window.location.href='exit.jsp';" value="退出">
	<input type="button"  onclick="window.location.href='index.jsp';" value="返回主页面">
</body>
</html>