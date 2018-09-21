<%@ page import="Jdbc.DBConnection,java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询</title>
</head>
<body>
<%
response.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");
request.setCharacterEncoding("utf-8");

String username=request.getParameter("username");

//method get	Workspace 编码为gbk时需要下面的转译
//username=new String(user.getBytes("iso-8859-1"),"utf-8");	

Connection ct=DBConnection.getConnection("exam");
Statement stmt=ct.createStatement();
ResultSet rs=stmt.executeQuery("select * from emp where ename='"+username+"';");
%><table border="1px"><%
while(rs.next()){	
	%><tr><td><%out.println(rs.getInt("empno")+"\t");%></td></tr><%
	%><tr><td><%out.println(rs.getString("ename")+"\t");%></td></tr><%
	%><tr><td><%out.println(rs.getString("job")+"\t");%></td></tr><%
	%><tr><td><%out.println(rs.getInt("mgr")+"\t");%></td></tr><%
	%><tr><td><%out.println(rs.getDate("hiredate")+"\t");%></td></tr><%
	%><tr><td><%out.println(rs.getString("sal")+"\t");%></td></tr><%
	%><tr><td><%out.println(rs.getString("COMM")+"\t");%></td></tr><%
	%><tr><td><%out.println(rs.getString("deptno")+"\t");%></td></tr><%	
}%></table><%
rs.close();
stmt.close();
ct.close();
out.println("over");
%>

</body>
</html>