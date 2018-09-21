<%@ page import="Jdbc.DBConnection,java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>删除</title>
</head>
<body>
<%
response.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");
String userid=request.getParameter("userid");
Connection ct=DBConnection.getConnection("exam");

String sql="delete from emp where empno=?";
PreparedStatement ps=ct.prepareStatement(sql);
ps.setString(1,userid);
ps.execute();
ps.close();
ct.close();
out.println("Delete");
%>
</body>
</html>