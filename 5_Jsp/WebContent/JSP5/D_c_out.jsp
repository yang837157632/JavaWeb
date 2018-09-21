<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>c:out</title>
</head>
<body>

	<!-- value	[default] [escapeXml] -->
	<c:out value="Hello JSP 2.0 !! " />
	<br />
	<c:out value="${3 + 5}" />
	<br />
	<c:out value="${param.data}" default="No Data" />
	<br />
	<c:out value="${param.data}">no data</c:out>
	<br />
	<c:out value="<B>有特殊字符</B>" />
	<br />
	<B><c:out value="有特殊字符" /></B>
	<br />
	<c:out value="<B>有特殊字符</B>" escapeXml="false" />

</body>
</html>