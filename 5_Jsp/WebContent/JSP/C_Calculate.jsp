<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'C_Calculate.jsp' starting page</title>

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
<%
	String num1 = request.getParameter("num1");
	String num2 = request.getParameter("num2");
	String oper = request.getParameter("operator");
	double d1 = 0;
	double d2 = 0;
	double res = 0;
	if(num1==null){
		num1="";
	}
	if(num2==null){
		num2="";
	}
	if (num1 != null && num2 != null && oper != null) {
		d1 = Double.parseDouble(num1);
		d2 = Double.parseDouble(num2);
		if (oper.equals("+")) {
			res = d1 + d2;
		} else if (oper.equals("-")) {
			res = d1 - d2;
		} else if (oper.equals("*")) {
			res = d1 * d2;
		} else {
			res = d1 / d2;
		}
	}
%>

<body>
	<form action="JSP2/C_Calculate.jsp" method="post">
		请输入第一个数:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="num1" value=<%=num1 %>><br> 
		请输入第二个数:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="num2" value=<%=num2 %>><br>
		请选择运算符号:&nbsp;&nbsp;&nbsp;&nbsp;<select name="operator">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
		</select><br>
		<!-- 第二种方法 -->
		<input type="submit" onclick="return check()" value="计算">
	</form>
	<hr>
	运算结果是：<%=res%>
</body>
</html>
