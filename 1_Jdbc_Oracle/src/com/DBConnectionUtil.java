
package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

public class DBConnectionUtil {
	static BasicDataSource basicDataSource;
	static PropertiesUtil propertiesUtil = new PropertiesUtil();

	static {
		basicDataSource = new BasicDataSource();

		String driverClassName = propertiesUtil.getValue("driverClassName");
		String url = propertiesUtil.getValue("url");
		String username = propertiesUtil.getValue("username");
		String password = propertiesUtil.getValue("password");
		int initialSize=Integer.parseInt(propertiesUtil.getValue("initialSize"));
		int maxIdle=Integer.parseInt(propertiesUtil.getValue("maxIdle"));

		basicDataSource.setDriverClassName(driverClassName);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		basicDataSource.setMaxIdle(maxIdle);
		basicDataSource.setInitialSize(initialSize);
	}

	//Connection
	public static Connection getConnection() {

		Connection connection = null;
		try {
			connection = basicDataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}

	//createStatement
	public static Statement getStatement() {
		Statement createStatement = null;
		try {
			createStatement = getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return createStatement;
	}

	//prepareStatement
	public static PreparedStatement getPreparedStatement(String sql) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prepareStatement;
	}
}
