<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>c:forEach</title>
</head>
<body>

	<%
	List userList = new ArrayList();
	userList.add("jack");
	userList.add("green");
	userList.add("lucy");
	request.setAttribute("userList",userList);
	%>
	<c:forEach var="username" items="${userList}">
		${username}<br>
	</c:forEach>

</body>
</html>