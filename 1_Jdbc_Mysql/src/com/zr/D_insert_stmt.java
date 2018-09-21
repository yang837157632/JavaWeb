package com.zr;

import java.sql.*;

public class D_insert_stmt 
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.jdbc.Driver");

		Connection ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","yang9264");

		String sql="insert into emp(empno,ename,sal,job) values(2001,'马云',50000,'CEO')";

		Statement stmt=ct.createStatement();

		stmt.executeUpdate(sql);

		stmt.close();
		ct.close();
		
		System.out.println("Demo4 over");
	}
}
