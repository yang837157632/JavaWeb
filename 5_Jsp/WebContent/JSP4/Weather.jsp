<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Weather</title>
</head>
<body>

<%
	String p = request.getParameter("provice");
	out.println("这里显示--"+p+"--的天气");
	out.flush();
%>

</body>
</html>