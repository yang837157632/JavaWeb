package com.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class DataSourceInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			Context initCtx = new InitialContext();
//			Context jndi = (Context) initCtx.lookup("java:comp/env");
//			DataSource source = (DataSource) jndi.lookup("mySource_Server_c3p0");
			
			DataSource source2 = (DataSource) initCtx.lookup("java:comp/env/mySource_Server_c3p0");
			
			Connection conn = source2.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from dept");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString("deptno")+"\t"+rs.getString("dname"));
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		
		try{
			Context initCtx = new InitialContext();
			Context jndi = (Context) initCtx.lookup("java:comp/env");
			DataSource source = (DataSource) jndi.lookup("mySource");
			
			Connection conn = source.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
