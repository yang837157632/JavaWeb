<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*,Jdbc.DBConnection" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
response.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");
request.setCharacterEncoding("utf-8");

String[] a=new String[8];
a[0]=request.getParameter("empno");
//a[0]="1001";
Connection ct=DBConnection.getConnection("exam");
String sql="select * from emp where empno=?";
PreparedStatement ps=ct.prepareStatement(sql);
ps.setString(1,a[0]);
ResultSet rs=ps.executeQuery();
while(rs.next())
{
	for(int i=1;i<a.length;i++){
		a[i]=rs.getString(i+1);
	}
}
%>
<form action="G_updateAction.jsp" method="post">
<table>
<tr><td>empno</td><td><input type="text" name="empno" value=<%=a[0] %>></td></tr>
<tr><td>ename</td><td><input type="text" name="ename" value=<%=a[1] %>></td></tr>
<tr><td>job</td><td><input type="text" name="job" value=<%=a[2] %>></td></tr>
<tr><td>mgr</td><td><input type="text" name="mgr" value=<%=a[3] %>></td></tr>
<tr><td>hiredate</td><td><input type="text" name="hiredate" value=<%=a[4] %>></td></tr>
<tr><td>sal</td><td><input type="text" name="sal" value=<%=a[5] %>></td></tr>
<tr><td>COMM</td><td><input type="text" name="COMM" value=<%=a[6] %>></td></tr>
<tr><td>deptno</td><td><input type="text" name="deptno" value=<%=a[7] %>></td></tr>
</table>
<input type="submit" name="提交">
<input type="reset" name="复原">
</form>
</body>
</html>