<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			function get(){
				var username = document.getElementById("username").value;
				var password = document.getElementById("password").value;
				alert(username+password);
				
				var xmlhr = new XMLHttpRequest();
				xmlhr.open("GET","<%=application.getContextPath()%>/TestAjaxServlet?username="
						+username+"&password="+password,true);
				xmlhr.send();
				
				xmlhr.onreadystatechange = function(){		
					if(xmlhr.readyState==4&&xmlhr.status==200){
						// 页面局部刷新的代码
						document.getElementById("div").innerHTML=xmlhr.responseText;
					}	
				}		
			}
			
			
			function post(){
				var username = document.getElementById("username").value;
				var password = document.getElementById("password").value;
				alert(username+password);
				
				var xmlhr = new XMLHttpRequest();
				xmlhr.open("POST","<%=application.getContextPath()%>/TestAjaxServlet",true);
				xmlhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				xmlhr.send("username="+username+"&password="+password);
				
				xmlhr.onreadystatechange = function(){		
					if(xmlhr.readyState==4&&xmlhr.status==200){
						document.getElementById("div").innerHTML=xmlhr.responseText;
					}	
				}		
			}
		</script>
	</head>
	
	<body>
		<form action="<%=application.getContextPath()%>/LoginServlet" method="post">
			用户:<input type="text" id="username"/><br>
			密码:<input type="text" id="password"/><br>
			<input type="submit" value="同步提交"/>
		</form>
		
		<input type="button" value="异步提交get" onclick="get()"/><br>
		<input type="button" value="异步提交post" onclick="post()"/><br>
		
		<div id="div" style="color:red">
		</div>
	</body>
</html>