package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
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
			
			//得到error信息
			String info=request.getParameter("info");
			if(info!=null){
				pw.println("<h1>你的用户名或是密码错误!</h1><br>");
			}
			
			pw.println("<h1>登录界面</h1>");
			pw.println("<form action=loginCl method=post>");
			pw.println("用户名:<input type=text name=username><br>");
			pw.println("密    码:<input type=password name=passwd><br>");
			pw.println("<input type=checkbox name=keep value=2>两周内不再重新登录<br>");
			pw.println("<input type=submit value=login><br>");
			pw.println("</form>");
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
