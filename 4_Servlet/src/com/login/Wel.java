package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Wel extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Wel() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection ct=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
					
			//从session中得到用户名
			HttpSession hs=request.getSession(true);
			String myName=(String)hs.getAttribute("uname");
			String name="";
			String passwd="";
			
			if(myName==null){
				
				//如果session中没有用户信息，再看看有没有cookie信息
				//从客户端得到所有cookie信息
				Cookie [] allCookies=request.getCookies();
		
				int i=0;
				//如果allCookies不为空...
				if(allCookies!=null){
			
					//从中取出cookie
					for(i=0;i<allCookies.length;i++){
				
						//依次取出
						Cookie temp=allCookies[i];
				
						if(temp.getName().equals("myname")){
						
							//得到cookie的值
							name=temp.getValue();
						}
						else if(temp.getName().equals("mypasswd")){
							passwd=temp.getValue();
						}
						
					}
					
					
					if(!name.equals("")&&!passwd.equals("")){
					
						//到logincl去验证
						response.sendRedirect("loginCl?username="+name +"&passwd="+passwd);
						return;
					}
						
				}
				
				//返回登录界面
				response.sendRedirect("Login?info=error1");
				return ;
			}
			
			//解决中文乱码
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			
			PrintWriter pw=response.getWriter();
			pw.println("<body bgcolor=#CED3FF>");
			
			pw.println("<img src=imgs/1.GIF>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您:"+myName+"<img src=imgs/me.gif><hr><center>");
			
			pw.println("<h1>管理用户</h1>");
		
			//做个超链接 
			pw.println("<br><a href=Login>返回重新登录</a>");
			
			
			//添加网页访问次数的功能

			
			//==================分页的功能====================
			
			int pageSize=3;//一页显示几条记录
			int pageNow=1;//希望显示第几页 
			
			
			//动态的接受pageNow
			String sPageNow=request.getParameter("pageNowok");
			
			if(sPageNow!=null){
				
				pageNow=Integer.parseInt(sPageNow);
				
			}
			
			
			//调用UserBeanCl
			UserBeanCl ubc=new UserBeanCl();
			ArrayList al=ubc.getResultByPage(pageNow,pageSize);
			
			
			pw.println("<table border=1>");
			pw.println("<tr bgcolor=pink><th>id</th><th>name</th><th>passwd</th><th>mail</th><th>grade</th><th>修改用户</th><th>删除用户</th></tr>");
			
			//定义一个颜色数组
			String [] mycol={"silver","pink"};
			
			
			for(int i=0;i<al.size();i++){
				
				UserBean ub=(UserBean)al.get(i);
				pw.println("<tr bgcolor="+mycol[i%2]+">");
				pw.println("<td>"+ub.getUserId()+"</td>");
				pw.println("<td>"+ub.getUserName()+"</td>");
				pw.println("<td>"+ub.getPasswd()+"</td>");
				pw.println("<td>"+ub.getMail()+"</td>");
				pw.println("<td>"+ub.getGrade()+"</td>");
				pw.println("<td><a href=Update?uId="+ub.getUserId()+"&uName="+ub.getUserName()+"&uPass="+ub.getPasswd()+"&uMail="+ub.getMail()+"&uGrade="+ub.getGrade()+">修改用户</a></td>");
				pw.println("<td><a href=DelUserCl?userid="+ub.getUserId()+" onclick=\"return window.confirm('确认删除')\">删除用户</a></td>");
				pw.println("</tr>");
				
			}
			
			pw.println("</table>");
			
			//上一页
			
			if(pageNow!=1)
			pw.println("<a href=Wel?pageNowok="+(pageNow-1)+">上一页</a>");
			
			int pageCount=ubc.getPageCount();
			//显示超链接
			for (int i=1; i<=pageCount; i++){
				
				pw.println("<a href=Wel?pageNowok="+i+">"+i+"</a>");	
			}			
			
			//下一页 
			if(pageNow!=pageCount)
			pw.println("<a href=Wel?pageNowok="+(pageNow+1)+">下一页</a><br>");
			pw.println("该网页被访问了"+this.getServletContext().getAttribute("visitTimes").toString()+"次<br>");
			
			//指定跳转到某页
			//这里实际是一个表单
			//你需要考虑问题：输入的页数过大?,输入不是数值又怎么办?
			pw.println("<form action=Wel>");
			pw.println("<input type=text name=pageNowok>");
			pw.println("<input type=submit value=go>");
			pw.println("</from><br>");
			
			pw.println("您的ip="+request.getRemoteAddr()+"<br>");
			pw.println("您的机器名="+request.getRemoteHost()+"<br>");
			pw.println("</center><hr><img src=imgs/mylogo.gif>");
			pw.println("</body>");
		
	    }
	    catch (Exception ex) {
	    	
	    	ex.printStackTrace();
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
