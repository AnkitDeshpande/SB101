package com.masai.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Mobile {

	static Connection connect() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/B27_Day09", "root", "root");
		} catch (Exception e) {
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

	private static void addMobile(Scanner scanner) {
		System.out.println("Enter the Model Number of the mobile: ");
		String model = scanner.next();

		System.out.println("Enter the Company Name of the mobile: ");
		String name = scanner.next();

		System.out.println("Enter the Manufacturing date of the mobile (yyyy-MM-dd): ");
		String mfgDate = scanner.next();

		System.out.println("Enter the price of the mobile: ");
		int price = scanner.nextInt();

		String query = "Insert into Mobile(model_no, company, price, mfgdate) Values(?, ?, ?, ?)";

		Connection con = connect();
		try {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, model);
			statement.setString(2, name);
			statement.setInt(3, price);
			statement.setString(4, mfgDate);

			if (statement.executeUpdate() > 0) {
				System.out.println("Mobile added Successfully");
			} else {
				System.out.println("Insertion failed.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(con);
		}
	}

	private static void updateMobile(Scanner scanner) {

		System.out.println("Enter Mobile Id : ");
		int id = scanner.nextInt();

		System.out.println("Enter the Model Number of the mobile: ");
		String model = scanner.next();

		System.out.println("Enter the Company Name of the mobile: ");
		String name = scanner.next();

		System.out.println("Enter the Manufacturing date of the mobile (yyyy-MM-dd): ");
		String mfgDate = scanner.next();

		System.out.println("Enter the price of the mobile: ");
		int price = scanner.nextInt();

		Connection con = connect();
		try {
			String query = "UPDATE Mobile SET model_no = ?, company = ?, MFGdate = ?, price = ? where id = ?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, model);
			ps.setString(2, name);
			ps.setString(3, mfgDate);
			ps.setInt(4, price);
			ps.setInt(5, id);

			if (ps.executeUpdate() > 0) {
				System.out.println("Updated Successfully. ");
			} else {
				System.out.println("Something went wrong.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			disconnect(con);
		}
	}

	private static void deleteMobile(Scanner scanner) {
		System.out.println("Enter Mobile Id to delete : ");
		int id = scanner.nextInt();

		Connection con = connect();
		try {
			String query = "DELETE FROM Mobile where id = ?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);

			if (ps.executeUpdate() > 0) {
				System.out.println("Deleted Successfully. ");
			} else {
				System.out.println("Something went wrong.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			disconnect(con);
		}
	}

	private static void viewAllMobiles() {
		Connection con = connect();

		try {
			String query = "Select * from Mobile order by price";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				System.out.println("No mobile found.");
			} else {
				do {
					System.out.print("Id = " + rs.getInt(1) + "\t");
					System.out.print("model Number = " + rs.getString(2) + "\t");
					System.out.print("company = " + rs.getString(3) + "\t");
					System.out.print("price  = " + rs.getInt(4) + "\t");
					System.out.print("MFG date  = " + rs.getString(5) + "\t");
					System.out.println();
				} while (rs.next());
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			disconnect(con);
		}
	}

	private static void searchMobile(Scanner scanner) {
		System.out.println("Enter the Model Number of the mobile: ");
		String model = scanner.next();
		Connection con = connect();

		try {
			String query = "Select * from Mobile where Model_no = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, model);
			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				System.out.println("No mobile found.");
			} else {
				System.out.print("Id = " + rs.getInt(1) + "\t");
				System.out.print("model Number = " + rs.getString(2) + "\t");
				System.out.print("company = " + rs.getString(3) + "\t");
				System.out.print("price  = " + rs.getInt(4) + "\t");
				System.out.print("MFG date  = " + rs.getString(5) + "\t");
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			disconnect(con);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int ch = 0;

		do {
			System.out.println("1. Add Mobile : ");
			System.out.println("2. Update Mobile : ");
			System.out.println("3. Delete Mobile : ");
			System.out.println("4. View all mobiles in ascending order : ");
			System.out.println("5. Search a mobile : ");
			System.out.println("0. Exit");
			System.out.println();
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				addMobile(sc);
				break;
			case 2:
				updateMobile(sc);
				break;
			case 3:
				deleteMobile(sc);
				break;
			case 4:
				viewAllMobiles();
				break;
			case 5:
				searchMobile(sc);
				break;
			case 0:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice! Please try again.");
			}

		} while (ch != 0);
	}

}
