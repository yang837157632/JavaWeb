<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'C_result.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<%
  	String num1=request.getParameter("num1");
  	String num2=request.getParameter("num2");
  	String oper=request.getParameter("operator");
  	double res=0;
  	
  	double d1=Double.parseDouble(num1);
  	double d2=Double.parseDouble(num2);

  	if(oper.equals("+")){
  		res=d1+d2;
  	}else if(oper.equals("-")){
  		res=d1-d2;
  	}else if(oper.equals("*")){
  		res=d1*d2;
  	}else{
  		res=d1/d2;
  	}
  	
  	out.println(res);
  	 %>

  </body>
</html>
