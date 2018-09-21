package Jdbc;

import java.sql.*;

public class DBConnection {
	public static Connection getConnection(String dbname) {
		Connection connection = null;
		try {
			// 加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");

			// 建立数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+ dbname, "root", "yang9264");

		} catch (Exception e) {
			e.printStackTrace();
		} 

		return connection;
	}
}
