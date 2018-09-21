package com.tsinghua;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CookieTest1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			response.setContentType("text/html;charset=gbk");
			PrintWriter pw=response.getWriter();
			
			//当用户访问该servlet时， 就将信息创建到该用户的cookie中
			//1. 现在服务器端创建一个cookie
			Cookie myCookie=new Cookie("color1","red");

			//2. 该cookie存在的时间
			myCookie.setMaxAge(30);
			//如果你不设置存在时间,那么该cookie将不会保存

			//3. 将该cookie写回到客户端
			response.addCookie(myCookie);

			pw.println("已经创建了cookie");
		}
		catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
