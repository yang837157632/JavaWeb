package com.tsinghua;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletContextTest2 extends HttpServlet {

	public ServletContextTest2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");

			PrintWriter pw=response.getWriter();

			//1得到servlet context
			ServletContext sc=this.getServletContext();

			//2得到属性和它对应的值
			String info=(String)sc.getAttribute("myInfo");
			pw.println ("从servlet context中得到属性 myinfo 它对应的值是"+info+"<br>");
			
			//比较session
			HttpSession hs=request.getSession(true);
			String val=(String)hs.getAttribute("test");
			if(val!=null) 
				pw.println("session 中的 test="+val+"<br>");
			
			//得到另外一个属性
			Cat myCat=(Cat)sc.getAttribute("cat1");
			if(myCat!=null)
				pw.println ("从servlet context中得到属性 cat1 他的名字是"+ myCat.getName()+" 他的年龄是"+myCat.getAge()+"<br>");

		}
		catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
