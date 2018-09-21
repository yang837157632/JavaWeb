package com.tsinghua;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiddenForm2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HiddenForm2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");

			PrintWriter pw=response.getWriter();

			//得到用户名
			String u=request.getParameter("username");
			//得到密码
			String p=request.getParameter("passwd");
			//得到隐藏的性别值
			String sex=request.getParameter("sex");

			pw.println("username="+u);
			pw.println("password="+p);
			pw.println("sex="+sex);

		}
		catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
