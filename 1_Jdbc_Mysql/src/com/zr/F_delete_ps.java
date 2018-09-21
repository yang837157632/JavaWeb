package com.zr;

import java.sql.*;

public class F_delete_ps 
{
	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3306/exam";
		String user="root";
		String password="yang9264";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection ct=DriverManager.getConnection(url,user,password);
			
			String sql="delete from emp where empno=?";
			PreparedStatement ps=ct.prepareStatement(sql);
			ps.setInt(1,2002);
			ps.executeUpdate();
			
			ps.close();
			ct.close();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("Demo6 over");
	}
}
