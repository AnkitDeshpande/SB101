package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DB {
	static String url;
	static String user;
	static String pass;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Connection connect() {
		Connection con = null;

		try {
			ResourceBundle rb = ResourceBundle.getBundle("db");
			url = rb.getString("URL");
			user = rb.getString("USERNAME");
			pass = rb.getString("PASSWORD");
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
