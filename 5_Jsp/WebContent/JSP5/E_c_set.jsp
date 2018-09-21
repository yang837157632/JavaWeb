<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>c:set</title>
</head>
<body>

	<!-- [value]	[var]	[scope] -->
	<c:set var="user1" value="jack" />
	<c:out value="${user1}" />
	<br>

	<c:set var="user2">lili</c:set>
	<c:out value="${user2}" />

</body>
</html>