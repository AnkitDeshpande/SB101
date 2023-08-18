package com.masai.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class DynamicQueries {

	/*
	 * static { try { Class.forName("com.mysql.cj.jdbc.Driver"); } catch
	 * (ClassNotFoundException e) {
	 * System.out.println("Minimum Requirements not matched"); System.exit(1); } 
	 * }
	 * doesnt matter if u write this code or not because the new version of jar
	 * detects jar in lib folders and automatically do it itself
	 */

	static Connection creatConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/Day09";
		String user = "root";
		String password = "root";
		try {
			con = DriverManager.getConnection(url, user, password);
			// System.out.println("Connection Eastablished.................");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	static void closeConnection(Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	static void insert(Scanner sc) {

		System.out.println("Enter Employee Id : ");
		String empId = sc.next();

		System.out.println("Enter Employee name : ");
		String empName = sc.next();

		System.out.println("Enter Employee salary : ");
		double empSalary = sc.nextDouble();

		System.out.println("Enter Joing date (YYYY-MM-DD) : ");
		String date = sc.next();

		Connection con = creatConnection();
		// ? placeholder for values
		String insertStatement = "insert into employee values(?, ?, ?, ?)";

		// providing values to placeholder
		try {
			PreparedStatement ps = con.prepareStatement(insertStatement);

			// providing values
			ps.setString(1, empId);
			ps.setString(2, empName);
			ps.setDouble(3, empSalary);
			ps.setString(4, date);

			if (ps.executeUpdate() > 0) {
				System.out.println("Employee added Successfully.");
			} else {
				System.out.println("Unable to add Employee.");
			}

			closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	static void update(Scanner sc) {

		System.out.println("Enter Employee Id : ");
		String empId = sc.next();

		System.out.println("Enter Employee name : ");
		String empName = sc.next();

		System.out.println("Enter Employee salary : ");
		double empSalary = sc.nextDouble();

		System.out.println("Enter Joing date (YYYY-MM-DD) : ");
		String date = sc.next();

		Connection con = creatConnection();

		String updateQ = "update employee SET empname = ?, salary = ?, joiningdate = ? where empid = ?";

		try {
			PreparedStatement ps = con.prepareStatement(updateQ);

			ps.setString(4, empId);
			ps.setString(1, empName);
			ps.setDouble(2, empSalary);
			ps.setString(3, date);

			if (ps.executeUpdate() > 0) {
				System.out.println("Employee updated Successfully.");
			} else {
				System.out.println("Unable to update Employee.");
			}
			closeConnection(con);
		} catch (Exception e) {
		}

	}

	static void view(Scanner sc) {

		Connection con = creatConnection();

		String viewQ = "SELECT * FROM employee";

		try {
			PreparedStatement ps = con.prepareStatement(viewQ);
			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				System.out.println("No employee found.");
			} else {
				System.out.println("Employee Details:");
				System.out.println("--------------------------------------------------------");
				System.out.println("ID\tName\t\tSalary\t\tJoining Date");
				System.out.println("--------------------------------------------------------");
				do {
					System.out.print(rs.getString(1) + "\t"); // Employee ID
					System.out.print(rs.getString(2) + "\t"); // Employee Name
					System.out.print(rs.getDouble(3) + "\t\t"); // Employee Salary
					System.out.print(rs.getDate(4) + "\n"); // Joining Date
				} while (rs.next());
			}
			System.out.println();

		} catch (Exception e) {
			System.out.println(e);
		}
		closeConnection(con);

	}

	static void delete(Scanner sc) {

		System.out.println("Enter Employee Id : ");
		String empId = sc.next();

		String deleteQ = "DELETE from employee where empid = ?";
		Connection con = creatConnection();

		try {

			PreparedStatement ps = con.prepareStatement(deleteQ);

			ps.setString(1, empId);

			if (ps.executeUpdate() > 0) {
				System.out.println("Record Deleted Successfully.");
			} else {
				System.out.println("Unable to Delete.");
			}

			closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice;

		do {
			System.out.println("1. Insert Employee.");
			System.out.println("2. View Employees.");
			System.out.println("3. Update Employee.");
			System.out.println("4. Delete Employee.");
			System.out.println("0. Exit.");

			choice = sc.nextInt();

			switch (choice) {
			case 1:
				insert(sc);
				break;
			case 2:
				view(sc);
				break;
			case 3:
				update(sc);
				break;
			case 4:
				delete(sc);
				break;
			case 0:
				System.out.println("Thanks for using services.");
				break;
			default:
				System.out.println("Invalid Selection, try again.");
			}

		} while (choice != 0);
		sc.close();
	}

}
