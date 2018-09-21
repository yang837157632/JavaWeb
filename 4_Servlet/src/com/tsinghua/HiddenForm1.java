package com.tsinghua;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiddenForm1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HiddenForm1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");

			PrintWriter pw=response.getWriter();

			String test="abc";
			//返回登录界面
			pw.println("<html>");
			pw.println("<body>");
			pw.println("<h1>登录界面</h1>");
			pw.println("<form action=HiddenForm2 method=post>");
			pw.println("用户名:<input type=text name=username><br>");
			pw.println("密码:<input type=password name=passwd><br>");
			pw.println("<input type=hidden name=sex value="+test+"><br>");
			pw.println("<input type=submit value=test><br>");
			pw.println("</form>");
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
