package com.pool;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class TestDBCPool {

	public static void main(String[] args) throws Exception {

		Properties p=new Properties();
//		p.load(new FileReader("src/config.properties"));
		p.load(new FileReader("src/com/source/parameter.properties"));

		BasicDataSourceFactory factory=new BasicDataSourceFactory();
		DataSource source=factory.createDataSource(p);

		Connection conn=source.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from type");

		while(rs.next()){
			System.out.println(rs.getInt(1)+":\t"+rs.getString(2));
		}

		if(rs!=null){
			rs.close();
		}

		if(stmt!=null){
			stmt.close();
		}

		if(conn!=null){
			conn.close();
		}

	}

}
