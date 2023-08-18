package com.masai.utitlity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
	static String url;
	static String user;
	static String password;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Connection connect() {
		Connection con = null;
		ResourceBundle rb = ResourceBundle.getBundle("db");
		String url = rb.getString("url");
		String user = rb.getString("user");
		String password = rb.getString("password");
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

	public static void disconnect(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
