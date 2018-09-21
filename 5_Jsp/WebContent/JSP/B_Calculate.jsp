<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'B_Calculate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="JS/A_check.js"></script>

  </head>
  
  <body>
  <!-- 第一种方法 -->
    <form action="JSP2/B_result.jsp" method="post" onsubmit="return check()">
    	请输入第一个数:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="num1" id="num1"><br>
    	请输入第二个数:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="num2" id="num2"><br>
    	请选择运算符号:&nbsp;&nbsp;&nbsp;&nbsp;<select name="operator">
    	<option value="+">+</option>
    	<option value="-">-</option>
    	<option value="*">*</option>
    	<option value="/">/</option>
    	</select><br>
    	<input type="submit" value="计算">
    	
    </form>
  </body>
</html>
