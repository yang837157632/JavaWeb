<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>

<script type="text/javascript">
	function refresh(){
		var rom=new Date();
		LoginForm.image.src="createImage.jsp?time="+rom;
	}
</script>

</head>
<body>

	<h1>欢迎登录系统</h1>

	<form action="validateCode.jsp" method="post" name="LoginForm">
		<label>账&nbsp;&nbsp;&nbsp;&nbsp;户：<input name="username" type="text" /></label><br><br> 
		<label>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input name="password" type="password" /></label><br><br> 
		<label>验证码：<input name="code" type="text" /></label><br><br> 
		<img name="image" border="0" src="createImage.jsp" /><br><br> 
		<input type="button" value="refresh" onclick="refresh()" />
		<input type="submit" value="commit" /> 
		<input type="reset" value="reset" />
	</form>

</body>
</html>