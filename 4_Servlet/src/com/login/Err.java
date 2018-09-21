package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Err extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public Err() {
    	
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			//中文乱码
			response.setContentType("text/html;charset=utf-8");
			
			PrintWriter pw=response.getWriter();
			
			//返回登录界面
			pw.println("<html>");
			pw.println("<body bgcolor=#CED3FF>");			
			pw.println("<img src=imgs/1.GIF>");
			pw.println("<hr>");
			pw.println("<center>");
			pw.println("<h1>很遗憾，操作不成功!</h1>");
			pw.println("<a href=Main>返回主界面</a>&nbsp;&nbsp;&nbsp;<a href=Wel>继续删除用户</a>");
			pw.println("</center>");
			pw.println("<hr>");
			pw.println("<img src=imgs/mylogo.gif>");
			pw.println("</body>");
			pw.println("</html>");
			
	    }
	    catch (Exception ex) {
	    	
	    	ex.printStackTrace();
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
