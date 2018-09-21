<%-- 
	// 1. 指令
	这里是page指令 
	include指令
	
	//2. 声明
	<%!   //属性、方法  %> 
	
	//3. 脚本
	
	//4. 动作
		<jsp:useBean />bean动作
		<jsp:setProperty /> 设置属性动作
		<jsp:forword url />转向动作
		<jsp:param />参数子动作
	//5. 注释
--%>
<%@ page import="StudentManagement.StudentDao"%>
<%@ page import="StudentManagement.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>registerAction</title>
</head>
<body>

<jsp:useBean id="stu" class="StudentManagement.Student"></jsp:useBean>
<jsp:setProperty property="*" name="stu"/>
<%-- <jsp:setProperty property="sid" value="8888" name="stu"/> --%>

<jsp:useBean id="dao" class="StudentManagement.StudentDao"></jsp:useBean>

<%
	//scriptlet
	//改变请求的编码方式 scriptlet
	request.setCharacterEncoding("utf-8");

	/* String sid = request.getParameter("sid");
	String sname = request.getParameter("sname");
	String province = request.getParameter("province");
	String sex = request.getParameter("sex");
	String age = request.getParameter("age");
	String titution = request.getParameter("titution");
 */
	//Student stu=new Student();
	
	/* stu.setSid(Integer.valueOf(sid));
	stu.setSname(sname);
	stu.setProvince(province);
	stu.setSex(sex);
	stu.setTitution(Integer.valueOf(titution));
	stu.setAge(Integer.valueOf(age)); */
	 
	 
	//StudentDao dao=new StudentDao();
	
	int result = dao.addStudent(stu);
	
	if(result==1){
%>
	<jsp:forward page="../success.html"></jsp:forward>
	<!-- 	out.write("<font size='14px' color='green'>SUCCESS</font>");  -->
<% 	
	}else{
%>
	<jsp:forward page="../failure.html"></jsp:forward>
		<!--out.write("<font size='14px' color='green'>Failure</font>"); -->
<% 
	}	
%>
	<%-- 静态包含一个页面 --%>
	<%--@ include file="NewFile.html" --%>
</body>
</html>