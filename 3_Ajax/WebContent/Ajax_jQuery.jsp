<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="js/jquery-1.4.4.js"></script>
		<script type="text/javascript">
			function a(){
				var username = $("#username").val();
				var password = $("#password").val();
				$.post("${pageContext.request.contextPath }/TestAjaxServlet",
						{username:username,password:password},
						function(data){
							alert(data)
							$("#div1").html(data);
						});
			}
			
			function bpost(){
				var username = $("#username").val();
				var password = $("#password").val();
				$.ajax({
					type:"post",
					url:"${pageContext.request.contextPath }/TestAjaxServlet",
					data:"username="+username+"&password="+password,
					success:function(data){
						$("#div0").html(data);						
					}
				});
			}
			
			function bget(){
				var username = $("#username").val();
				var password = $("#password").val();
				$.ajax({
					type:"get",
					url:"${pageContext.request.contextPath }/TestAjaxServlet?username="+username+"&password="+password,
					success:function(data){
						$("#div0").html(data);						
					}
				});
			}
			
			function c(){
				$.getJSON("js/a.js",function(data){
					$(data).each(function(i,d){
						alert(i+"  "+d.name+"  "+d.age);
					});
				});
			}
			
			function d(){
				$.getScript("js/b.js");
				//执行js代码
			}
		</script>
	</head>
	
	<body>
		<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
			用户:<input type="text" id="username"/><br>
			密码:<input type="text" id="password"/><br>
			<input type="submit" value="同步提交"/>
		</form>
		
		<input type="button" value="异步提交post" onclick="a()"/><br>
		<input type="button" value="异步提交ajax_post" onclick="bpost()"/><br>
		<input type="button" value="异步提交ajax_get" onclick="bget()"/><br>
		<input type="button" value="测试json" onclick="c()"/><br>
		<input type="button" value="测试scrip" onclick="d()"/><br>
		
		<div id="div0" style="color:red">
		</div>
		<div id="div1" style="color:green">
		</div>
	</body>
</html>