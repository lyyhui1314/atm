<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
</head>
<body>
		<input type="button" onclick="window.location.href='mred.jsp';" value="取款">
		<form action="MInqServlet" method="post">
			<input type="submit" value="查询余额">
		</form>
		<br>
		
		<input type="button"  onclick="window.location.href='madd.jsp';" value="存款">
		<input type="button"  onclick="window.location.href='changep.jsp';" value="修改密码">
		<br>
		
		<input type="button"  onclick="window.location.href='mtraid.jsp';" value="转账">
		<br>
		<input type="button"  onclick="window.location.href='login.jsp';" value="重新登录">
		<input type="button"  onclick="window.location.href='exit.jsp';" value="退出">
</body>
</html>