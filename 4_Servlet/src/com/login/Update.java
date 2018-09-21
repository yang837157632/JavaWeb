package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Update() {
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

			pw.println("<h1>修改用户界面</h1>");

			pw.println("<form action=updateCl>");
			pw.println("<table border=1>");

			pw.println("<tr><td>id</td><td><input readonly name=uId type=text value="+request.getParameter("uId")+"></td></tr>");
			pw.println("<tr><td>name</td><td><input readonly type=text value="+request.getParameter("uName")+"></td></tr>");
			pw.println("<tr><td>passwd</td><td><input name=newPasswd type=text value="+request.getParameter("uPass")+"></td></tr>");
			pw.println("<tr><td>email</td><td><input name=newEmail type=text value="+request.getParameter("uMail")+"></td></tr>");
			pw.println("<tr><td>grade</td><td><input name=newGrade type=text value="+request.getParameter("uGrade")+"></td></tr>");
			pw.println("<tr><td colspan=2><input type=submit value=修改用户></td></tr>");

			pw.println("</table></form>");

			pw.println("</center><hr><img src=imgs/mylogo.gif>");
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
