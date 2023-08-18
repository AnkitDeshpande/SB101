package com.masai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//import com.mysql.cj.protocol.Resultset;

public class ConnectionDemo {

	/*
	 * static { try { Class.forName("com.mysql.cj.jdbc.Driver"); } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 * 
	 * *IMPORTANT* : it doesnt matter if u write static block where we get
	 * class.forname code or not because the new version of jar detects jar in lib
	 * folders and automatically do it itself
	 * 
	 */

	static Connection connect() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day09", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		Scanner sc = new Scanner(System.in);

		int ch = 0;

		do {
			System.out.println("1. Insert a Student");
			System.out.println("2. view Students");
			System.out.println("3. Update a Student");
			System.out.println("4. Delete a Student");
			System.out.println("0. Exit");

			System.out.println("Enter Your choice : ");

			ch = sc.nextInt();

			switch (ch) {
			case 1:
				insertStudent(sc);
				break;
			case 2:
				viewStudents(sc);
				break;
			case 3:
				// updateStudent(sc);
				break;
			case 4:
				// deleteStudent(sc);
				break;
			case 0:
				System.out.println("Have a nice day.");
				break;
			default:
				System.out.println("Invalid input.");
			}
		} while (ch != 0);
		sc.close();
	}

	private static void viewStudents(Scanner sc) {
		System.out.println("Enter Student roll number :");
		int roll = sc.nextInt();

		Connection con = connect();
		String query = "Select * from Student where rollno = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, roll);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void insertStudent(Scanner sc) {
		System.out.println("Enter Student Details : ");
		System.out.println("Enter Student Name : ");
		String name = sc.next();
		System.out.println("Enter Student Roll number : ");
		int roll = sc.nextInt();
		System.out.println("Enter Student Marks : ");
		double marks = sc.nextDouble();

		String query = "insert into Student Value('" + roll + "','" + name + "','" + marks + "')";

		Connection con = connect();

		try {
			PreparedStatement ps = con.prepareStatement(query);
			if (ps.executeUpdate(query) > 0) {
				System.out.println("Student added Successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
