package com.masai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JdbcDemoDay10 {
	static String URL;
	static String username;
	static String password;

	/*
	 * static { try { Class.forName("com.mysql.cj.jdbc.Driver"); } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

	static Connection connect() {
		Connection con = null;
		try {
			ResourceBundle rb = ResourceBundle.getBundle("db");
			URL = rb.getString(URL);
			username = rb.getString(username);
			password = rb.getString(password);

			con = DriverManager.getConnection(URL, username, password);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}

	static void disconnect(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = connect();
		System.out.println("Connection eastablished");
		disconnect(con);
	}

}
