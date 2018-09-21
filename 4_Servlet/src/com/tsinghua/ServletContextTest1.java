package com.tsinghua;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletContextTest1 extends HttpServlet {

    public ServletContextTest1() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {			

			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			
			PrintWriter pw=response.getWriter();
			
			//1得到servletcontext
			//2添加属性
			ServletContext sc=this.getServletContext();
			sc.setAttribute("myInfo","我是顺平");			
			pw.println ("给sevlet context中添加一个属性 myInfo 该属性对应的值是一个字符串我是顺平<br>");
			
			
			//比较session
			HttpSession hs=request.getSession(true);
			hs.setAttribute("test","中国人");
			hs.setMaxInactiveInterval(60*3);
			pw.println("向session中添加一个test属性 他的值是 中国人<br>");	
			
			
			//===当然在servletcontext中放入一个对象
			Cat myCat=new Cat("小明",30);			
			sc.setAttribute("cat1",myCat);			
			pw.println ("给sevlet context中添加一个属性 cat1 该属性对应的值是一个猫对象<br>");
			
	    }
	    catch (Exception ex) {
	    	
	    	ex.printStackTrace();
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

class Cat{
	
	private String name;
	private int age;
	
	public Cat(String name,int age){
		
		this.name=name;
		this.age=age;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getAge(){		
		return this.age;
	}
}
