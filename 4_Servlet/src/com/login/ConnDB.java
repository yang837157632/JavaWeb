package com.login;

import java.sql.*;

import javax.sql.*;
import javax.naming.*;

public class ConnDB {

	private Connection ct=null;
	
	public static void main(String[] args) {
		System.out.println(new ConnDB().getConn());
	}

	public Connection getConn(){

		try {

			Class.forName("com.mysql.jdbc.Driver");

			ct=DriverManager.getConnection("jdbc:mysql:///users","root","yang9264");

		}
		catch (Exception ex) {

			ex.printStackTrace();
		}

		return ct;
/*
	    //使用数据源连接池的方式连接数据库,只可用于Servlet
	    try {	    

	    	//创建一个上下文环境
	    	Context con=new javax.naming.InitialContext();

	    	//通过con得到数据源
	    	DataSource ds=(DataSource) con.lookup("java:comp/env/mySource");

	    	ct=ds.getConnection();

	    	System.out.println ("使用连接池的方式");
	    }catch (Exception ex) {

	    	ex.printStackTrace();
	    }

	    return ct;
*/	    
		
	}
}
