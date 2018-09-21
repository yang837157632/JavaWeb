package com.tsinghua;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SessionTest2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");

			PrintWriter pw=response.getWriter();


			//得到和req相关联的session,如果没有就创建session
			HttpSession ht=request.getSession(true);

			//得到session 的id
			String sessionId=ht.getId();

			pw.println("sessionTest2 的session id="+sessionId+"<br>");

			//得到session中的某个属性
			String myName=(String)ht.getAttribute("name");

			pw.println("name="+myName);

		}
		catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
