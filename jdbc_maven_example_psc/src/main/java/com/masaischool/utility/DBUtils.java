package com.masaischool.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 
 * @author Masai
 * Useful for creating and closing the connection
 * It is a utility class that contains general functions related to opening and closing connection to the database
 */
public class DBUtils {
	static String url;
	static String username;
	static String password;
	
	static {	//will executed only once
		//Class.forName("com.mysql.cj.jdbc.Driver"); not required if jdk >= 1.6
		
		ResourceBundle bundle = ResourceBundle.getBundle("dbdetails");
		//ResourceBundle bundle = ResourceBundle.getBundle("dbdetails.properties"); ERROR
		url = bundle.getString("url");
		username = bundle.getString("username");
		password = bundle.getString("password");
	}
	
	/**
	 * Create a connection to the database based on the details available in the properties file
	 * @return: Connection object upon successful connection
	 * @throws SQLException: If anything went wrong while creating connection
	 */
	public static Connection createConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	/**
	 * Closes the connection base on the parameter connection object
	 * @param connection: Connection object for the connection to closed
	 * @throws SQLException if something went wrong while closing connection
	 */
	public static void closeConnection(Connection connection) throws SQLException  {
		if(connection != null) {
			connection.close();
		}
	}
}
