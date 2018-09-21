package com.tsinghua;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletFileTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletFileTest2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");

			PrintWriter pw=response.getWriter();

			//创建一个FileWriter  看内存数据 ->  磁盘文件(写入,输出)
			//看内存数据 <-  磁盘文件(读入,输入)
			FileWriter  f=new FileWriter("f:\\myCounter.txt");

			BufferedWriter bw=new BufferedWriter(f);

			//在文件中写入数据	
			bw.write("234");

			//关闭文件流
			bw.close();

			pw.println("在文件中写入了数据");

		}
		catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}


}
