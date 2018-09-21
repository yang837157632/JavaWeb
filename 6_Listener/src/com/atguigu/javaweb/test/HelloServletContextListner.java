package com.atguigu.javaweb.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
    
public class HelloServletContextListner 
	implements ServletContextListener, ServletRequestListener, HttpSessionListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext 对象被创建。 " + sce.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext 对象被销毁。" + sce.getServletContext());
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("HttpSession 被创建。" + se.getSession());
	}
       
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("HttpSession 被销毁" + se.getSession());
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("ServletRequest 被销毁" + sre.getServletRequest());
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("ServletRequest 被创建" + sre.getServletRequest());
	}

}
