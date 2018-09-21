package com.zr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class B_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public B_Servlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String name=request.getParameter("username");
		request.setAttribute("name", name);
		request.getRequestDispatcher("success.jsp").forward(request, response);

//		PrintWriter out=response.getWriter();
//		out.write(name);
//		out.write("这里是servlet");
//		out.flush();
	}
}
