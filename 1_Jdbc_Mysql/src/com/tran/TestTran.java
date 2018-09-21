package com.tran;

import java.sql.*;

public class TestTran {
	
	private Connection conn=null;
	
	private Statement stmt=null;
	
	public static void main(String[] args) throws Exception{
		
		boolean flag=new TestTran().delete();
		
		if(flag){
			
			System.out.println("Success");
			
		}else{
			
			System.out.println("Failure");
			
		}
	
	}
	
	public boolean delete() throws Exception{
		
		boolean flag=false;
		
		conn=DBConn.getConnection();
		
		stmt=conn.createStatement();
		
		try{
					
			conn.setAutoCommit(false);
			
			stmt.executeUpdate("insert into dept values(50, '市场部', '南京')");
			
			stmt.executeUpdate("update dept set loc='重庆' where deptno=30");
			
			conn.commit();
			
			conn.close();
			
			flag=true;			
			
		}catch(Exception e){
			
			conn.rollback();
			
			conn.close();
			
			e.printStackTrace();
			
		}
				
		return flag; 
		
	}

}
