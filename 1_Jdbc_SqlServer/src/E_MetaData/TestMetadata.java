package E_MetaData;

import java.sql.*;

import B_Connection.DButil;

public class TestMetadata {
	public static void main(String[] args) {
		testDatabaseMetaData();
		System.out.println();;
		testResultSetMetaData();
	}
	
	static void testResultSetMetaData(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		String sql="select * from Student";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			ResultSetMetaData md=rs.getMetaData();
			
			int count=md.getColumnCount();
			for(int i=1;i<=count;i++){
				String name=md.getColumnName(i);
				System.out.println(name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		
	}
	
	static void testDatabaseMetaData(){
		DButil util=new DButil();
		Connection conn=util.openConnection();
		try {
			DatabaseMetaData metadata=conn.getMetaData();
			System.out.println("Version: "+metadata.getDatabaseMajorVersion());
			System.out.println("Name: "+metadata.getDatabaseProductName());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}		
	}

}
