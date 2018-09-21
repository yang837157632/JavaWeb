package A_Intro;

import java.sql.*;

public class DButil {
	public static void main(String[] args) {
		DButil util=new DButil();
		Connection conn=util.getConnection();
		System.out.println(conn);
	}
	
	public Connection getConnection(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=JDBCDemo","sa","yang9264");
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
