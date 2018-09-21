package com.atguigu.fileupload.app.listener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.atguigu.fileupload.app.utils.FileUploadAppProperties;

public class FileUploadAppListener implements ServletContextListener {

    public FileUploadAppListener() {

    }

    public void contextInitialized(ServletContextEvent arg0) {
    	InputStream in = getClass().getClassLoader().getResourceAsStream("/upload.properties");
    	
    	Properties properties = new Properties();
    	try {
			properties.load(in);
			
			for(Map.Entry<Object, Object> prop: properties.entrySet()){
				String propertyName = (String) prop.getKey();
				String propertyValue = (String) prop.getValue();
				
				FileUploadAppProperties.getInstance().addProperty(propertyName, propertyValue);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void contextDestroyed(ServletContextEvent arg0) {

    }
	
}
