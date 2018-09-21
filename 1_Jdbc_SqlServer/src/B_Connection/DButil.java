package B_Connection;

import java.sql.*;
import java.util.*;

public class DButil {
	public static void main(String[] args) {
		DButil util=new DButil();
		Connection conn=util.openConnection();

//		util.trans();
		util.add();
		
	}
	
	public void trans(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		String sql="update Account set balance=balance-300 where name='Tom'";
		String sql2="update Account set balance=balance+300 where name='Kate'";
		try {
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
			conn.commit();
			System.out.println("Bingo");

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
				System.out.println("Failed");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			util.closeConnection(conn);
		}
	}
		
	public void add(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		String sql="insert into Users values('Lise','787')";
		try {
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn.commit();
			System.out.println("Bingo");
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
				System.out.println("Failed");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			util.closeConnection(conn);
		}
		
	}
	
	public Connection getConnectin(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=JDBCDemo","sa","yang9264");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Connection getConnection(String url,String driver,String username,String password){
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Connection openConnection(){
		Properties prop=new Properties();
		String driver=null;
		String url=null;
		String username=null;
		String password=null;
		try {
			prop.load(this.getClass().getClassLoader().getResourceAsStream("DBConfig.properties"));
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			username=prop.getProperty("username");
			password=prop.getProperty("password");
			Class.forName(driver);
			return DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
