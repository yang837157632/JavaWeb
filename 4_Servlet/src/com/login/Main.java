package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Main() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");

			PrintWriter pw=response.getWriter();

			//返回登录界面
			pw.println("<html>");
			pw.println("<body bgcolor=#CED3FF>");

			pw.println("<img src=imgs/1.GIF><hr><center>");

			pw.println("<h1>主界面</h1>");
			pw.println("<a href=Wel>管理用户</a><br>");
			pw.println("<a href=???>添加用户</a><br>");
			pw.println("<a href=???>查找用户</a><br>");
			pw.println("<a href=???>安全退出</a><br>");
			pw.println("</center><hr><img src=imgs/mylogo.gif>");
			pw.println("</body>");
			pw.println("</html>");

		}catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
