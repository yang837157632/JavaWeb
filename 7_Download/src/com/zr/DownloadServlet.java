package com.zr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DownloadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getParameter("path"); // 获取上传文件的路径
		//path = new String(path.getBytes("iso-8859-1"), "UTF-8");
		File file = new File(path); // 根据该路径创建文件对象
		InputStream in = new FileInputStream(file); // 创建文件字节输入流
		OutputStream os = response.getOutputStream(); // 创建输出流对象
		response.addHeader("Content-Disposition", "attachment;filename="
				+ new String(file.getName().getBytes("GBK"), "iso-8859-1")); // 设置应答头信息
		response.addHeader("Content-Length", file.length() + "");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/octet-stream");
		int data = 0;
		while ((data = in.read()) != -1) { // 循环读取文件
			os.write(data); // 向指定目录中写文件
		}
		os.close(); // 关闭流
		in.close();
	}

}
