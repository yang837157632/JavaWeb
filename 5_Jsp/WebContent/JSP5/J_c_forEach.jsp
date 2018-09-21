<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>c:forEach</title>
</head>
<body>

	<table>
		<tr>
			<th>行号</th>
			<th>数值</th>
			<th>平方</th>
		</tr>
		<c:forEach var="x" begin="0" end="10" step="2" varStatus="status">
			<tr>
				<td><c:out value="${status.count}" /></td>
				<td><c:out value="${x}" /></td>
				<td><c:out value="${x * x}" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>