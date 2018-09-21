package com.tran;

import java.sql.*;

public class DBConn {
	
	private final static String url="jdbc:mysql://localhost:3306/exam";
	
	private final static String username="root";
	
	private final static String password="yang9264";
	
	public static Connection getConnection(){
		
		Connection conn=null;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection(url, username, password);
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return conn;
	}

}
