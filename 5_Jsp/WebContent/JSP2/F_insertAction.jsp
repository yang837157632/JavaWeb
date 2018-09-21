<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*,Jdbc.DBConnection" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增加</title>
</head>
<body>
<%
response.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");
request.setCharacterEncoding("utf-8");

String empno=request.getParameter("empno");
String ename=request.getParameter("ename");
String job=request.getParameter("job");
String mgr=request.getParameter("mgr");
String hiredate=request.getParameter("hiredate");
String sal=request.getParameter("sal");
String COMM=request.getParameter("COMM");
String deptno=request.getParameter("deptno");

Connection ct=DBConnection.getConnection("exam");
String sql="insert into emp(empno,ename,job,mgr,hiredate,sal,COMM,deptno) values(?,?,?,?,?,?,?,?)";
PreparedStatement ps=ct.prepareStatement(sql);
ps.setString(1,empno);
ps.setString(2,ename);
ps.setString(3,job);
ps.setString(4,mgr);
ps.setString(5, hiredate);
ps.setString(6,sal);
ps.setString(7,COMM);
ps.setString(8, deptno);
ps.executeUpdate();
ps.close();
ct.close();
out.println("Insert");
%>
</body>
</html>