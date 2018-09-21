package com.zr;

import java.sql.*;

public class C_select_stmt 
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.jdbc.Driver");

		Connection ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","yang9264");
		
		String sql="select * from emp";

		Statement stmt=ct.createStatement();

		ResultSet rs=stmt.executeQuery(sql);

		System.out.println("empno"+"\t"+"ename"+"\t"+"job"+"\t"+"mgr"+"\t"+"hiredate"+"\t"+"sal");
		while(rs.next())
		{
			System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+
								rs.getString("job")+"\t"+rs.getInt("mgr")+"\t"+
								rs.getDate("hiredate")+"\t"+rs.getDouble("sal"));
		}		

		rs.close();
		stmt.close();
		ct.close();
		
		System.out.println("Demo3 over");		
	}
}
