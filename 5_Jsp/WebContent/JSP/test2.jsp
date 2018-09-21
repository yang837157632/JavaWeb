<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>test2</title>
</head>
<body>
<%
if (Calendar.AM_PM!=Calendar.PM)
{
out.println("Good Morning");
}else
{
out.println("Good Evening");
}
%>
</body>
</html>