package com.zr;

import java.sql.*;

public class E_insert_ps 
{
	public static void main(String[] args) throws Exception 
	{

		Class.forName("com.mysql.jdbc.Driver");

		Connection ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","yang9264");
		
		String sql="insert into emp(empno,ename,sal,job) values(?,?,?,?)";

		PreparedStatement ps=ct.prepareStatement(sql);
		ps.setInt(1,2002);
		ps.setString(2,"蚂蚁");
		ps.setDouble(3,1000);
		ps.setString(4,"Boss");

		ps.executeUpdate();	

		ps.close();
		ct.close();
		
		System.out.println("Demo5 over");		
	}
}
