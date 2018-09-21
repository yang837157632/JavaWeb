package com.systop.model.util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;

public class FileUploadUtil {

	private HttpServlet httpServlet = null;

	private HttpServletRequest request = null;

	private HttpServletResponse response = null;
	
	private String directory; //保存到服务器的目录

	private String fileName = null; //被保存的文件名称
	
	public FileUploadUtil(){}
	
	/**
	 * 构造器
	 * @param httpServlet
	 * @param request
	 * @param response
	 * @param directory
	 */
	public FileUploadUtil(HttpServlet httpServlet, HttpServletRequest request,
			HttpServletResponse response,String directory) {
		this.httpServlet = httpServlet;
		this.request = request;
		this.response = response;
		this.directory = directory;
	}

	/**
	 * 文件上传
	 *
	 */
	public SmartUpload uploadFile() {
		
		SmartUpload su = new SmartUpload(); //创建SmartUpload对象，上传文件全靠他
		
		/*生成PageContext对象，用来初始化SmartUpload
		 * 参数列表：
		 *httpServlet：当前的Servelet对象；
		 *request：请求对象；
		 *response：响应对象；
		 *null：错误页面地址，在这里指定为null；
		 *true：是否与当前session相关；
		 *8192：缓存大小；
		 *true:表示自动刷新
		 */
		PageContext pageContext = JspFactory.getDefaultFactory()
				.getPageContext(httpServlet, request, response, null, true, 8192, true);
		
		try {
			
			su.initialize(pageContext);
			su.upload();  //将客户端数据上传到服务器
			File file = su.getFiles().getFile(0); //得到上传后的文件对象，注意上传页面不能以html为扩展名，否则会报1205的错误
			fileName =file.getFileName(); //得到上传后的文件名
			file.saveAs("/" + directory + "/" + fileName); //将上传后的文件保存到指定目录
			return su;
			
		} catch (Exception e) {

			e.printStackTrace();
		} 
		return null;
	}

	/**
	 * 返回上传后的文件路径
	 * @return
	 */
	public String getFilePath() {
		return directory + "/" + fileName;
	}
}
