package com.atguigu.javaweb.test;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class TestAttributeListener implements ServletContextAttributeListener,
	ServletRequestAttributeListener, HttpSessionAttributeListener{

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("向 request 中添加了一个属性: " + srae.getName() + ": " + srae.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("从 request 中移除了一个属性: " + srae.getName() + ": " + srae.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("request 中属性替换了: " + srae.getName() + ": " + srae.getValue());
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println("向 context 中添加了一个属性: " + scab.getName() + ": " + scab.getValue());		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("从context 中移除了一个属性: " + scab.getName() + ": " + scab.getValue());		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("context 中属性替换了: " + scab.getName() + ": " + scab.getValue());		
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("向 session 中添加了一个属性: " + se.getName() + ": " + se.getValue());		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("从 session 中移除了一个属性: " + se.getName() + ": " + se.getValue());		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("session 中属性替换了: " + se.getName() + ": " + se.getValue());		
	}

}
