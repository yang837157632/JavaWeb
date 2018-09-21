package com.zr;

import java.sql.*;

public class B_update_ps 
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","yang9264");
		
		String sql="update emp set sal=? where empno=?";

		PreparedStatement ps=ct.prepareStatement(sql);
		
		ps.setDouble(1, 9999);
		ps.setInt(2, 1001);
		
		ps.executeUpdate();
		
		ps.close();
		ct.close();
		
		System.out.println("Demo2 over");		
	}
}
