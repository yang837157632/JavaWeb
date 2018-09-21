package F_PreparedStatement;

import java.sql.*;
import B_Connection.DButil;

//Statement: 静态的
//PreparedStatement：动态的

public class TestPS {
	public static void main(String[] args) {
		getPreparedStatement(2);
		
//		add();
		
		Student s=new Student();
		s.setAge(21);
		s.setName("Rose");
		add(s);
		
		delete(5);
		
//		Student s=new Student();
//		s.setId(3);
//		s.setName("Tom2");
//		s.setAge(21);
//		update(s);
		
		select();
	}
	
	static void select(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		String sql="select * from Student where age>?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,20);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				System.out.println(id+" "+name+" "+age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		
	}
	
	static void update(Student s){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		String sql="update Student set name=?,Age=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setInt(2, s.getAge());
			ps.setInt(3, s.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		
	}
	
	static void delete(int id){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		String sql="delete from student where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		
	}
	
	static void add(Student s){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		String sql="insert into student values(?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setInt(2, s.getAge());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		
	}
	
	static void add(String name,int age){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		String sql="insert into student values(?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		
	}
	
	static void add(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		String sql="insert into student(name,age) values(?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "Alice");
			ps.setInt(2, 25);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		
	}
	
	static void getPreparedStatement(int id){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		String sql="select * from student where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			System.out.println(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}		
	}

}

class Student{
	private String name;
	private int age;
	private int id;
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	
}
