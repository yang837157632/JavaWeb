<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Expression Language</title>
</head>
<body>

	<%
		String username = "mike";
		request.setAttribute("username", username);
	%>
	<table width="75%" border="1" align="center">
		<tr>
			<th>运算符</th>
			<th>结果</th>
		</tr>
		<tr>
			<td>14＋3</td>
			<td>${14+3}</td>
		</tr>
		<tr>
			<td>14-3</td>
			<td>${14-3}</td>
		</tr>
		<tr>
			<td>14*3</td>
			<td>${14*3}</td>
		</tr>
		<tr>
			<td>14/3</td>
			<td>${14/3}</td>
		</tr>
		<tr>
			<td>14%3</td>
			<td>${14%3}</td>
		</tr>
		<tr>
			<td>14==3</td>
			<td>${14==3}</td>
		</tr>
		<tr>
			<td>14 != 3</td>
			<td>${14!=3}</td>
		</tr>
		<tr>
			<td>14 < 3</td>
			<td>${14 < 3}</td>
		</tr>
		<tr>
			<td>14 > 3</td>
			<td>${14 > 3}</td>
		</tr>
		<tr>
			<td>14 <=3</td>
			<td>${14 <=3}</td>
		</tr>
		<tr>
			<td>14 >=3</td>
			<td>${14 >=3}</td>
		</tr>
		<tr>
			<td>true && false</td>
			<td>${true && false}</td>
		</tr>
		<tr>
			<td>true || false</td>
			<td>${true || false}</td>
		</tr>
		<tr>
			<td>! false</td>
			<td>${! false}</td>
		</tr>
		<tr>
			<td>empty username</td>
			<td>${empty username}</td>
		</tr>
		<tr>
			<td>! empty username</td>
			<td>${!empty username}</td>
		</tr>
		<tr>
			<td>empty password</td>
			<td>${empty password}</td>
		</tr>
	</table>

</body>
</html>