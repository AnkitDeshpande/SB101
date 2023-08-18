package com.masai.firstmavenproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class App {

	static String url;
	static String user;
	static String password;

	static {
		ResourceBundle rs = ResourceBundle.getBundle("dbdetails");
		url = rs.getString("URL");
		user = rs.getString("USERNAME");
		password = rs.getString("PASSWORD");
	}

	static Connection connect() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	
	public static void main(String[] args) {
		
		try(Connection con = connect()) {
			System.out.println("Connection Successful.");
			
			con.setAutoCommit(false);
			
			String q = "INSERT into employee value(?,?,?,?)";
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Bye-bye");
	}
}
