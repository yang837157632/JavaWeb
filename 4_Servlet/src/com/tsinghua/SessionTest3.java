package com.tsinghua;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SessionTest3() {
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

			//向session中添加一个属性(String 类型的)			
			ht.setAttribute("you","郭嘉");
			ht.setAttribute("he","王儁");


			pw.println("在没有删除you属性前 you的值="+ ht.getAttribute("you")+"<br>");

			//从session中删除you属性
			ht.removeAttribute("you");
			//设置session的请求间隔时间为0，慎用
			//ht.setMaxInactiveInterval(0);

			pw.println("删除you属性后 you的值="+ ht.getAttribute("you")+"<br>");

			pw.println("删除you属性后 he的值="+ ht.getAttribute("he")+"<br>");

		}
		catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
