<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.text.SimpleDateFormat,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>动态输出服务器端当前日期</title>
</head>

<!--这是客户端查看源代码能够看到的注释，叫做HTML注释  -->
<%--这是客户端查看源代码看不到的注释，叫做JSP注释 --%>

<body>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
out.println(path+"<br><br>");
out.println(basePath+"<br><br>");
out.println("/abc"+"<br><br>");
%>

hello呀！<br>
服务器端当前日期是：
<%
SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
String currentDate = sdf.format(new Date());
//response.sendRedirect("success.html");	url不变
//request.getRequestDispatcher("success.html").forward(request, response);	url改变，只可用于servlet
%>
<%=currentDate %>
    

 
</body>
</html>