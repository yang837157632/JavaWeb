<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Param</title>
</head>
<body>
<!-- Parameter -->
	姓名：${param.username}
	<br> 密码：${param.password}
	<br> 性别：${param.sex}
	<br> 兴趣：${paramValues.habbit[0]},${paramValues.habbit[1]}

</body>
</html>