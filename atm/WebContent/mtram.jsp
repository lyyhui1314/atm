<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>转账金额页</title>
</head>
<body>
	<form action="MTraNextServlet" method="post">
		${info }<br> 请输入转账金额：
		<input type="text" name="tramo" value="${param.tramo }"><br>
		<input type="submit" value="确定">
	</form>
	<input type="button" onclick="window.location.href='mtraid.jsp';" value="返回">
	<form action="MInqServlet" method="post">
		<input type="submit" value="查询余额">
	</form>
	<input type="submit" onclick="window.location.href='index.jsp';" value="返回主页面">
</body>
</html>