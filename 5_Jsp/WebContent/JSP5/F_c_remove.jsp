<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>c:remove</title>
</head>
<body>

	<!-- var	[scope] -->
	<c:set var="username">lili</c:set>
	<c:out value="${username}" />
	<br>
	
	<c:remove var="username" />
	<c:out value="${username}" default="no name" />

</body>
</html>