<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>取款页</title>
</head>
<body>
	<form action="MRedServlet" method="post" name="form">
		<input type="hidden" name="act" value=""> 
		${info }<br> 
		请选择或输入取款金额：<br>
		<input type="button" value="100" onclick="fun(100)"> 
		<input type="button" value="1000" onclick="fun(1000)"> <br> 
		<input type="button" value="300" onclick="fun(300)"> 
		<input type="button" value="1500" onclick="fun(1500)"> <br> 
		<input type="button" value="500" onclick="fun(500)"> 
		<input type="button" value="2000" onclick="fun(2000)"> <br>
		
		 <input type="text" name="money" value=""> <br> 
		 <input type="submit" value="确定">
	</form>
	<form action="MInqServlet" method="post">
		<input type="submit" value="查询余额">
	</form>
	<input type="submit" onclick="window.location.href='index.jsp';" value="返回主页面">
</body>

<script>
	function fun(n) {
		switch (n) {
		case 100:
			form.act.value = "100";
			break;
		case 300:
			form.act.value = "300";
			break;
		case 500:
			form.act.value = "500";
			break;
		case 1000:
			form.act.value = "1000";
			break;
		case 1500:
			form.act.value = "1500";
			break;
		case 2000:
			form.act.value = "2000";
			break;
		}
	}
</script>
</html>



