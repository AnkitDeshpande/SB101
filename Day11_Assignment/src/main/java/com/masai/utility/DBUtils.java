package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
	static String url;
	static String user;
	static String pass;
	
	static {
		ResourceBundle rb = ResourceBundle.getBundle("DB");
		url = rb.getString("url");
		user = rb.getString("user");
		pass = rb.getString("pass");
	}
	
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection(url,user,pass);
	}
}
