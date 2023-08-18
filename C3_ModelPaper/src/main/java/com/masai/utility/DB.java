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
			e.printStackTrace();
		}
	}

	public static Connection connect() {

		Connection con = null;
		try {
			ResourceBundle rb = ResourceBundle.getBundle("db");
			url = rb.getString("url");
			user = rb.getString("user");
			pass = rb.getString("pass");
			con = DriverManager.getConnection(url, user, pass);
			System.out.println(con != null ? "Connected to database" : "Couldn't connect to database");
			return con;
		} catch (SQLException e) {
			System.out.println("Couldn't connect to database" + e.getMessage());
		}
		return con;
	}

	public static void close(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
