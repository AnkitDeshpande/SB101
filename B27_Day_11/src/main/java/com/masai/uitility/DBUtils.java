package com.masai.uitility;

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
			e.printStackTrace();
		}
	}

	public static Connection connect() {
		Connection con = null;
		try {
			ResourceBundle rb = ResourceBundle.getBundle("db");
			url = rb.getString("url");
			user = rb.getString("username");
			password = rb.getString("password");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;

	}

	public static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
