package com.masai.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDemo {
	public static void main(String[] args) {
		Connection con = null;
		try {
			// step-01
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step-02
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Day09", "root", "root");
			System.out.println("Connection Eastablished.................");

			// form a create table query
			String tableQuery = "Create table employee(" + "empid varchar(5) primary key,"
					+ "empname varchar(20) not null," + "salary double not null," + "joiningDate Date)";
			// this is static query since it is not added by users

			// use statement to execute the static query
			Statement s = con.createStatement();
			System.out.println("Statement object created.");
			
			
			s.executeUpdate(tableQuery);
			System.out.println("Table Created.");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					// step-03
					con.close();
					System.out.println("Connection closed....");

				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2);
				}
			}
		}
		System.out.println("Bye Bye!");
	}
}
