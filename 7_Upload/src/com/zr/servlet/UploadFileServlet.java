package com.zr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.systop.model.util.FileUploadUtil;

public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UploadFileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FileUploadUtil fuu=new FileUploadUtil(this,request,response,"upload");
		
		SmartUpload su=fuu.uploadFile();
		
		request.setAttribute("result", "Success");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
