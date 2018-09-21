<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>test</title>
</head>
<body>
<h2>Test JSP</h2>
<ul>
<li>Current time: <%=new java.util.Date() %></li>
<li>Host Name: <%=request.getRemoteHost() %></li>
<li> ServerInfo: <%=application.getServerInfo() %></li>
<li>Session ID: <%=session.getId() %></li>
<li>Parameter: <%=request.getParameter("name") %></li>
</ul>

</body>
</html>