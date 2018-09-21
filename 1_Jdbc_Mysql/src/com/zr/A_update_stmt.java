package com.zr;

import java.sql.*;

public class A_update_stmt 
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","yang9264");
		//"jdbc:mysql://127.0.0.1:3306/exam"
		
		String sql="update emp set sal=10000 where empno=1001";
		
		Statement stmt=conn.createStatement();
		
		stmt.executeUpdate(sql);
		
		stmt.close();
		conn.close();
		
		System.out.println("Demo1 over");		
	}
}
