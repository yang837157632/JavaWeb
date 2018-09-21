<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<%

String code=(String)session.getAttribute("image");

String para=request.getParameter("code");

if(code.equalsIgnoreCase(para)){
	out.write("Bingo");

}else{
	out.write("oooooo");
}

%>

</body>
</html>