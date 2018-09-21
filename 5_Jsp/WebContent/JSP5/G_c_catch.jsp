<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>c:catch</title>
</head>
<body>

	<!-- [var] -->
	<c:catch var="error_Message">
	<%
  	String eFormat="not number";
  	int i=Integer.parseInt(eFormat);
  	out.print(eFormat);
  	%>
	</c:catch>
	${error_Message}

</body>
</html>