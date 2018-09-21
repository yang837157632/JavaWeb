package com.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestC3p0 {

	public static void main(String[] args){

		Connection ct=null;
		Statement stmt=null;
		ResultSet rs=null;

		try{
			ComboPooledDataSource source=new ComboPooledDataSource();
			
//			ResourceBundle bundle=ResourceBundle.getBundle("config");
			ResourceBundle bundle=ResourceBundle.getBundle("com/source/parameter");
			
			source.setDriverClass(bundle.getString("driverClassName"));			
			source.setJdbcUrl(bundle.getString("url"));
			source.setPassword(bundle.getString("password"));
			source.setUser(bundle.getString("username"));

			ct=source.getConnection();
			stmt=ct.createStatement();
			rs=stmt.executeQuery("select * from type ");
			
			while(rs.next()){
				System.out.println(rs.getInt(1)+":\t"+rs.getString(2));
			}
			
		}catch(Exception e){

			e.printStackTrace();

		}finally{

			try{

				if(rs!=null){
					rs.close();
				}

				if(stmt!=null){
					stmt.close();
				}

				if(ct!=null){
					ct.close();
				}

			}catch(Exception e){
				
				e.printStackTrace();
			}

		}

	}

}
