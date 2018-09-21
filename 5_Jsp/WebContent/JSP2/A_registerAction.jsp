<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setCharacterEncoding("UTF-8");

	String username = request.getParameter("username");
	String password = request.getParameter("password");

	if(username.equals("zhang3"))
		out.println("坏小子, not allowed");
	else
		out.println("good boy, login success");

	out.flush();
%>