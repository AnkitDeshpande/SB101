package com.masai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MobileDemo {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("minimum requirement not matched. ");
			System.exit(1);
		}
	}

	static Connection connect() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/day09", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	static void disconnect(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}

	private static void add(Scanner sc) {
		System.out.println("Enter model number : ");
		String n = sc.next();
		System.out.println("Enter company name : ");
		String name = sc.next();
		System.out.println("Enter Price : ");
		int price = sc.nextInt();
		System.out.println("Enter Manafacture date : ");
		String jDate = sc.next();

		String insert = "INSERT into mobile (model_no, company, price, mfgdate) values(?,?,?,?)";

		Connection connect = connect();

		try {
			PreparedStatement ps = connect.prepareStatement(insert);
			ps.setString(1, n);
			ps.setString(2, name);
			ps.setInt(3, price);
			ps.setString(4, jDate);

			if (ps.executeUpdate() > 0) {
				System.out.println("Mobile Added successfully");
			} else {
				System.out.println("Unable to add Mobile.");
			}

			disconnect(connect);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void update(Scanner sc) {
		System.out.println("Enter model number : ");
		String n = sc.next();
		System.out.println("Enter company name : ");
		String name = sc.next();
		System.out.println("Enter Price : ");
		int price = sc.nextInt();
		System.out.println("Enter Manafacture date : ");
		String jDate = sc.next();

		String upt = "update mobile set company=?, price=?, mfgdate=? where model_no = ?";

		Connection con = connect();

		try {
			PreparedStatement ps = con.prepareStatement(upt);

			ps.setString(1, name);
			ps.setInt(2, price);
			ps.setString(3, jDate);
			ps.setString(4, n);

			if (ps.executeUpdate() > 0) {
				System.out.println("Mobile Updated successfully.");
			} else {
				System.out.println("Unable to Update.");
			}

			disconnect(con);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private static void delete(Scanner sc) {
		System.out.println("Enter model number : ");
		String n = sc.next();

		Connection con = connect();

		String dlt = "Delete from mobile where model_no = ?";

		try {
			PreparedStatement ps = con.prepareStatement(dlt);
			ps.setString(1, n);

			if (ps.executeUpdate() > 0) {
				System.out.println("Mobile Deleted Successfully.");
			} else {
				System.out.println("Unable to delete.");
			}

			disconnect(con);

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

	}

	private static void view(Scanner sc) {

		Connection con = connect();

		String v = "Select * from mobile order by price";

		try {
			PreparedStatement ps = con.prepareStatement(v);

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
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		disconnect(con);
	}

	private static void search(Scanner sc) {
		System.out.println("Enter model number : ");
		String n = sc.next();

		String srch = "Select * from mobile where model_no = ?";

		Connection con = connect();

		try {

			PreparedStatement ps = con.prepareStatement(srch);

			ps.setString(1, n);

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				System.out.println("No Mobile Found");
			} else {
				System.out.println("Mobile Found:");
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("Model Number: " + rs.getString("model_no"));
				System.out.println("Company: " + rs.getString("company"));
				System.out.println("Price: " + rs.getDouble("price"));
				System.out.println("Manufacturing Date: " + rs.getDate("MFGdate"));
			}
			disconnect(con);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice;

		do {
			System.out.println("1. Add New Mobile.");
			System.out.println("2. Update a Mobile.");
			System.out.println("3. Delete Mobile.");
			System.out.println("4. View all Mobiles in Ascending order.");
			System.out.println("5. Search a Mobile.");
			System.out.println("0. Exit.");

			choice = sc.nextInt();

			switch (choice) {
			case 1:
				add(sc);
				break;
			case 2:
				update(sc);
				break;
			case 3:
				delete(sc);
				break;
			case 4:
				view(sc);
				break;
			case 5:
				search(sc);
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
