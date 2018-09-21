package com.atguigu.javaweb;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UserNameFilter implements Filter {

    public UserNameFilter() { }

	public void destroy() { }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String initUser = filterConfig.getInitParameter("username");
		String username = request.getParameter("username");
		
		if(!initUser.equals(username)){
			request.setAttribute("message", "用户名不正确");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

	private FilterConfig filterConfig;
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
