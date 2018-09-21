<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Test 1</title>
<%!
int age=30;
String name="amaker";
int count=1;
public String hello()
{
	return "hello, "+name;
}
%>
</head>
<body>
Age: <%=age %><br>
Name: <%=name %><br>
<%=hello() %><br>
counts: <%=count++ %>
</body>
</html>