package G_CallableStatement;

import java.sql.*;

import B_Connection.DButil;

//mysql存储过程语句
//CREATE PROCEDURE all_stu() SELECT * FROM StudentTbl;
//CALL all_stu;


//CREATE PROCEDURE insert_user(IN n VARCHAR(20),IN a VARCHAR(20)) INSERT INTO studenttbl(NAME,age) VALUES(n,a);
//CALL insert_user('Joe',28);


//此存储过程语句有错误，不知错误在什么地方  
//CREATE PROCEDURE getAgeByName(IN n VARCHAR(20),OUT ret_age INT)
//BEGIN
//DECLARE a INT;
//SELECT age INTO a FROM studenttbl WHERE NAME=n;
//SET ret_age=a;
//END;

public class TestCL {
	public static void main(String[] args) {
		testCallableStatement1();
		testCallableStatement2();
		testCallableStatement3();
	}
	
	static void testCallableStatement3(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		String sql="{call getAgeByName(?,?)}";
		try {
			CallableStatement cl=conn.prepareCall(sql);
			cl.setString(1, "Robb");
			cl.registerOutParameter(2, Types.INTEGER);
			cl.execute();
			int age=cl.getInt(2);
			System.out.println(age);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}
	
	static void testCallableStatement2(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		String sql="{call insert_user(?,?)}";
		try {
			CallableStatement cl=conn.prepareCall(sql);
			cl.setString(1, "Robb");
			cl.setInt(2, 32);
			cl.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}
	
	static void testCallableStatement1(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		String sql="{call all_stu}";
		try {
			CallableStatement cl=conn.prepareCall(sql);
			ResultSet rs=cl.executeQuery();
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

}
