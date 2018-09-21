package com.tsinghua;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletFileTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletFileTest1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");

			PrintWriter pw=response.getWriter();

			//创建一个FileReader
			FileReader  f=new FileReader("f:\\myCounter.txt");

			BufferedReader bw=new BufferedReader(f);

			//读出一行数据   	
			String numVal=bw.readLine();

			//一定要关闭文件流   	
			bw.close();

			pw.println("从文件中读取的数据是:"+numVal);

		}
		catch (Exception ex) {

			ex.printStackTrace();

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
