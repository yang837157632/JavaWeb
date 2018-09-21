package D_ResultSet;

import java.sql.*;
import java.util.*;

import B_Connection.DButil;

public class TestRS {
	public static void main(String[] args) {
		testResultSet();
		
		List list=ListStu();
		System.out.println(list);
		
//		updateableResultSet();		mysql支持
		
	}
	
	static void updateableResultSet(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		String sql="select * from Student";
		Statement stmt=null;
		
		try {
//			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stmt.executeQuery(sql);
			
//			添加一行
			rs.moveToInsertRow();
			rs.updateString("name","Kate");
			rs.updateInt(3,21);
			rs.insertRow();
			
//			更新一行
			rs.absolute(2);
			rs.updateString("name", "bigTom");
			rs.updateRow();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	static List ListStu(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		String sql="select * from Student";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List list=new ArrayList();
			
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				Stu s=new Stu();
				s.setAge(age);
				s.setId(id);
				s.setName(name);
				list.add(s);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	static void testResultSet(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		String sql="select * from Student";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
//			rs.absolute(3);		mysql支持
			
			System.out.println(rs.getRow());
			System.out.println(rs.isBeforeFirst());
			rs.next();
			System.out.println(rs.getRow());
			System.out.println(rs.isBeforeFirst());
			
//			System.out.println(rs.first());		mysql支持
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

class Stu{
	private int id;
	private String name;
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}

