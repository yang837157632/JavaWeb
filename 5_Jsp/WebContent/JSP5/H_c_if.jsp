<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>c:if</title>
</head>
<body>

	<!-- test	[var]	[scope] -->
	<c:set var="age" value="24" />
	<c:if test="${age<18}">少年</c:if>
	<c:if test="${age>=18&&age<=30}">青年</c:if>
	<c:if test="${age>30&&age<=60}">中年</c:if>
	<c:if test="${age>60}">老年</c:if>

</body>
</html>