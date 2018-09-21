package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleUtil {
       
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "Star1";
		String password = "123456";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
