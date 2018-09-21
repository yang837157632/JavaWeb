package A_Intro;

import java.sql.*;

public class Test {
	public static void main(String[] args) {
		Test test=new Test();
		test.list();
	}
	
	public void list(){
		DButil util=new DButil();
		Connection conn=util.getConnection();
		
		String sql="select * from users";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				int id=rs.getInt(1);
				String username=rs.getString(2);
				String password=rs.getString(3);
				System.out.println(id+" "+username+" "+password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}		
	}
	
}