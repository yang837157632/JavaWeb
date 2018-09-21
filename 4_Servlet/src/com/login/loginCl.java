package com.login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginCl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginCl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection ct=null;
		Statement sm=null;
		ResultSet rs=null;

		try {		

			//接受用户名和密码
			String u=request.getParameter("username");
			String p=request.getParameter("passwd");

			//调用UserBeanCl，1.创建一个对象
			UserBeanCl ubc=new UserBeanCl();


			//2.使用UserBeanCl的方法
			if(ubc.checkUser(u,p)){
				
				//合法用户
				String keep=request.getParameter("keep");

				if(keep!=null){
					//将用户名和密码保存在客户端(cookie)
					//创建
					Cookie name=new Cookie("myname",u);
					Cookie pass=new Cookie("mypasswd",p);

					//设置时间 
					name.setMaxAge(14*24*3600);
					pass.setMaxAge(14*24*3600);

					//回写到客户端
					response.addCookie(name);
					response.addCookie(pass);

				}

				//将用户名和密码放入到session中
				HttpSession hs=request.getSession(true);
				hs.setMaxInactiveInterval(30);
				hs.setAttribute("uname",u);

				//将serlvetContext中的 visitTime所对应的值++
				String times=this.getServletContext().getAttribute("visitTimes").toString();

				//对times++再重新放回servlet
				this.getServletContext().setAttribute("visitTimes",(Integer.parseInt(times)+1)+"");

				//跳转到wel
				response.sendRedirect("Main");

			}else{

				//不合法
				//跳转
				response.sendRedirect("Login");//写你要到的servlet的那个url
			}

		}
		catch (Exception ex) {

			ex.printStackTrace();
		}finally{

			try {

				if(rs!=null){

					rs.close();
				}
				if(sm!=null){

					sm.close();
				}
				if(ct!=null){

					ct.close();
				}
			}
			catch (Exception ex) {

				ex.printStackTrace();
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	//重写init函数
	public void init(){

		try {

			//只会被调用一次
			//创建一个FileReader
			FileReader  f=new FileReader("f:\\myCounter.txt");
			BufferedReader br=new BufferedReader(f);

			//读出一行数据   	
			String numVal=br.readLine();

			//一定要关闭文件流   	
			br.close();

			//将times值放入到servletcontext
			this.getServletContext().setAttribute("visitTimes",numVal);

			System.out.println ("inti 被调用");
			
		}catch (Exception ex) {

			ex.printStackTrace();
		}

	}

	//重写destroy函数
	public void destroy(){

		try {

			//在将新的次数写会去
			FileWriter  fw=new FileWriter("f:\\myCounter.txt");
			BufferedWriter bw=new BufferedWriter(fw);

			//在文件中写入数据	
			bw.write(this.getServletContext().getAttribute("visitTimes").toString());

			//关闭文件流
			bw.close();

			System.out.println ("destroy 被调用");
		
		}catch (Exception ex) {

			ex.printStackTrace();

		}
	}

}
