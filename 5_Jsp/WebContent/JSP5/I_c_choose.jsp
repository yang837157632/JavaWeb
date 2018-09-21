<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>c:choose</title>
</head>
<body>

	<!-- test	[var]	[scope] -->
	<c:set var="i" value="52" />
	<c:choose>
		<c:when test="${i<18}">少年</c:when>
		<c:when test="${i>18&&i<=30}">青年</c:when>
		<c:when test="${i>30&&i<=60}">中年</c:when>
		<c:otherwise>老年	</c:otherwise>
	</c:choose>

</body>
</html>