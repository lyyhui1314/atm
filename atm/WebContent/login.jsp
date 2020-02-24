<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页</title>

</head>
<body>
	<div id="center">
		<form action="LoginServlet" method="post">
			<p style="color: red">${info }</p>
			<input type="text" name="id" placeholder="请输入账号" ><br> 
			<input type="password" name="password" placeholder="请输入密码" ><br>
			<input type="submit" value="登录">
			<input type="reset" value="重置">
		</form>
	</div>
</body>
</html>