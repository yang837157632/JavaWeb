package myServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("get...");
		
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		System.out.println(username);

//		response.getWriter().write("get...Ajax");
		request.getRequestDispatcher("WEB-INF/msg.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("post...");
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String password = request.getParameter("password");
		System.out.println(password);
		request.setAttribute("a", "asd");
		response.getWriter().write("你好，世界");
//		request.getRequestDispatcher("WEB-INF/msg.jsp").forward(request, response);

	}

}
