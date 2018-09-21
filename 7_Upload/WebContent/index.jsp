<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Insert title here</title>

<script type="text/javascript">
	function validate() {
		if (form1.file.value == "") {
			alert("请选择要上传的文件");
			return false;
		}
	}
</script>

</head>
<body>

	<form action="/7_Upload/UploadFileServlet" method="post"
		enctype="multipart/form-data" name="form1" onsubmit="return validate()">
		<ul>
			<li>请选择要上传的附件：</li>
			<li><input type="text" name="name" /></li>
			<li></li>
			<li><input type="file" name="file" /></li>
			<li><input type="submit" name="Submit" value="上传" /> 
				<input type="reset" name="Submit2" value="重置" />
			</li>
		</ul>
	</form>

	<%
		if (request.getAttribute("result") != null) { //判断保存在request范围内的对象是否为空
			out.println("<script >alert('" + request.getAttribute("result")
					+ "');</script>"); //页面显示提示信息    	  
		}
	%>

</body>
</html>