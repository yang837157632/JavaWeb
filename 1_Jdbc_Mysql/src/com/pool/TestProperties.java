package com.pool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
	
	public static void main(String[] args) throws Exception {
		
		Properties p=new Properties();
		
//		InputStream in=Object.class.getResourceAsStream("/config.properties");
		
		InputStream in=Object.class.getResourceAsStream("/com/source/parameter.properties");
		
		p.load(in);
		
		in.close();
		
		System.out.println(p.getProperty("driverClassName"));
		
	}

}
