<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>registerAction</title>
</head>
<body>

<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");	
	response.setContentType("text/html;charset=utf-8");
	
	String provice = request.getParameter("province"); 
	String url="Weather_"+provice +".jsp";

	out.println(provice);
%>
	<jsp:forward page="<%=url %>"></jsp:forward>
	
</body>
</html>