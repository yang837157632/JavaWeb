package com.history;

//这是创建Serlvet的第一种方法,使用实现servlet接口的方式来开发

import javax.servlet.*;
import java.io.*;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class TestServlet implements Servlet {

	//该函数用于初始化该serlvet(类似于类的构造函数)
	//该函数只会被调用一次(当用户第一次访问该servlet时被调用)
	public void init(ServletConfig parm1) throws ServletException {
		System.out.println ("init it");
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	//这个函数用于处理业务逻辑
	//程序员应当把业务逻辑代码写在这里
	//当用户每访问该servlet是，都会调用
	//req: 用于获得客户端(浏览器)的信息
	//res: 用于向客户端(浏览器)返回信息
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {		
		System.out.println ("service it");
		//从res中得到PrintWriter
		PrintWriter pw=res.getWriter();
		pw.println("hello,world");
	}

	public String getServletInfo() {
		return "";
	}

	//销毁servlet实例(释放内存)
	//1.reload 该serlvet(webApps) //2.关闭tomcat //3.关机
	public void destroy() {
		System.out.println ("destroy!");
	}

}
