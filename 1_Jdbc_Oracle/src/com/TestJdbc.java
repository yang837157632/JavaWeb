package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {

	public static void main(String[] args) throws Exception {

//		test_driverManager();
//		test_dataSource();
		test_dataSource2();
	}

	//封装版
	public static void test_dataSource() throws SQLException {

		Statement createStatement = DBConnectionUtil.getStatement();

		boolean execute = createStatement
				.execute("update s_department set xyrs = '10000' where id = '1'");
		
		System.out.println(execute);

		createStatement.close();
	}
	
	public static void test_dataSource2() throws SQLException {
		
		String sql="update s_department set xyrs = ? where id = '1'";

		PreparedStatement prepareStatement = DBConnectionUtil.getPreparedStatement(sql);
		
		prepareStatement.setInt(1, 20000);

		boolean execute = prepareStatement.execute();
		
		System.out.println(execute);

		prepareStatement.close();
	}


	//原始版
	public static void test_driverManager() throws Exception {
		
		Connection connection=OracleUtil.getConnection();

		Statement createStatement = connection.createStatement();

		boolean execute = createStatement
				.execute("update s_department set xyrs = '5000' where id = '1'");
		
		System.out.println(execute);

		createStatement.close();
		connection.close();
	}

}
