<%@ page import="Jdbc.DBConnection,java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SELECT</title>
</head>
<body>
<%
response.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");

Connection ct=DBConnection.getConnection("exam");
Statement stmt=ct.createStatement();
ResultSet rs=stmt.executeQuery("select * from emp");
%>
<table style="border:1px solid red" align="center" cellpadding="0" cellspacing="0">
<%
while(rs.next()){
%>
<tr  height="30px">
	<td style="border:1px dashed green;width:50px;"><%=(rs.getInt("empno")+"\t")%></td>
	<td style="border:1px dashed green;width:50px;"><%=(rs.getString("ename")+"\t")%></td>
	<td style="border:1px dashed green;width:50px;"><%=(rs.getString("job")+"\t")%></td>
	<td style="border:1px dashed green;width:50px;"><%=(rs.getInt("mgr")+"\t")%></td>
	<td style="border:1px dashed green;width:100px;"><%=(rs.getDate("hiredate")+"\t")%></td>
	<td style="border:1px dashed green;width:100px;"><%=(rs.getString("sal")+"\t")%></td>
	<td style="border:1px dashed green;width:50px;"><%=(rs.getString("COMM")+"\t")%></td>
	<td style="border:1px dashed green;width:50px;"><%=(rs.getString("deptno")+"\t")%></td>
</tr>
<%	
}%></table>
<%
rs.close();
stmt.close();
ct.close();
%>
</body>
</html>