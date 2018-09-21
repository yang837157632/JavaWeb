package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelUserCl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelUserCl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");			
			
			//调用userBeancl的删除用户的方法，完成删除
			UserBeanCl ubc=new UserBeanCl();
			
			//接收从wel.java中传递的id
			String id=request.getParameter("userid");
			if(ubc.delUser(id)){
				
				//删除成功!
				response.sendRedirect("Ok");
				
			}else{
				
				//失败
				response.sendRedirect("Err");
				
			}
		}catch (Exception ex) {
	    	
	    	ex.printStackTrace();
	    }			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
