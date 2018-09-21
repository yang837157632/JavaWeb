package com.tsinghua;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CookieTest3() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			response.setContentType("text/html;charset=gbk");

			PrintWriter pw=response.getWriter();

			//从客户端得到所有cookie信息
			Cookie [] allCookies=request.getCookies();

			int i=0;
			//如果allCookies不为空...
			if(allCookies!=null){

				//从中取出cookie
				for(i=0;i<allCookies.length;i++){

					//依次取出
					Cookie temp=allCookies[i];

					if(temp.getName().equals("color1")){

						//将该cookie删除		//个人运行 Cookie未删除
						temp.setMaxAge(0);
						pw.println("删除了color1这个cookie");
						break;

					}
				}

			}
		}
		catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
