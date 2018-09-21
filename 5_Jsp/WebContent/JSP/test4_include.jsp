<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>include test</title>
</head>
<body>

    这是本标签部分 。<br><br><br>
    <!-- 静态引入，引入的部分不单独编译，把两个jsp翻译成一个Servlet文件 -->
    <h1>静态引入</h1>
    <%@ include file="include.jsp" %><br><br><br>
    
    
    <!-- 动态引入，引入的部分单独编译,把两个jsp翻译成分别翻译成Servlet文件 -->
    <h1>动态引入</h1>
    <jsp:include page="include.jsp" flush="true"></jsp:include>

</body>
</html>