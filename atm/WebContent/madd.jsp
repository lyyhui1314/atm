<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>存款页</title>
</head>
<body>
	<form action="MAddServlet" method="post">
		${info }<br>
		请输入存款金额： <input type="text" name="money" value="">
		<input type="submit" value="确定">
	</form>

	<form action="MInqServlet" method="post">
		<input type="submit" value="查询余额">
	</form>

	<input type="button" onclick="window.location.href='exit.jsp';" value="退出">
	<input type="button" onclick="window.location.href='index.jsp';" value="返回主页面">

</body>
</html>