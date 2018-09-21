<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	提示信息页：<br>
	<font color="red">对不起，用户名或者密码错误</font>
	<%String a=(String) request.getAttribute("a");
	if((a!=null)&&(a.equals("asd"))){
		out.print("12345");
	}else{
		out.print("54321");
	}
	%>