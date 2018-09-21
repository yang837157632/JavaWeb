package C_Statement;

import java.sql.*;
import B_Connection.DButil;

public class TestStmt {
	public static void main(String[] args) {
//		getStatement();
//		createTable();
		add();
		delete();
		update();
		select();
	}
	
	static void select(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		try {
			String sql="select * from Student";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString("name")+" "+rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}
	
	static void update(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		try {
			String sql="update Student set name='Jim' where id=2";
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Bingo update");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}
	
	static void delete(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		try {
			String sql="delete from Student where id=3";
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Bingo delete");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}

	static void add(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		try {
			String sql="insert into Student values('Tom',20)";
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Bingo add");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}
	
	static void createTable(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="CREATE TABLE Student(id INT PRIMARY KEY Identity(1,1),NAME VARCHAR(20),age INT);";
			stmt.execute(sql);
			System.out.println("Bingo");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}		
	}
	
	static void getStatement(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		try {
			Statement stmt=conn.createStatement();
			System.out.println(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}		
	}
	
}

