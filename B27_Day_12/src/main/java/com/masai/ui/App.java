package com.masai.ui;

import java.util.Scanner;

import com.masai.dto.BankAccount;
import com.masai.services.BankAccountService;
import com.masai.services.BankaccServImpl;

public class App {

	private static void createAccount(Scanner scanner) {
		System.out.println("Enter acount id  (*Note : not the account number*):  ");
		int id = scanner.nextInt();
		System.out.print("Enter account number: ");
		String accNumber = scanner.next();
		System.out.print("Enter initial balance: ");
		double Bal = scanner.nextDouble();
		BankAccount acc = new BankAccount(id, accNumber, Bal);
		BankAccountService bas = new BankaccServImpl();
		try {
			System.out.println(bas.createAccount(acc));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void deposit(Scanner scanner) {
		System.out.println("Enter acount id  (*Note : not the account number*):  ");
		int id = scanner.nextInt();
		System.out.println("Enter the amount to add :");
		int amt = scanner.nextInt();
		BankAccountService bas = new BankaccServImpl();
		try {
			bas.deposit(id, amt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void withdraw(Scanner scanner) {
		System.out.println("Enter acount id  (*Note : not the account number*):  ");
		int id = scanner.nextInt();
		System.out.println("Enter the amount to withdraw :");
		int amt = scanner.nextInt();
		BankAccountService bas = new BankaccServImpl();
		try {
			bas.withdraw(id, amt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void getAccountById(Scanner scanner) {
		System.out.println("Enter acount id  (*Note : not the account number*):  ");
		int id = scanner.nextInt();
		BankAccountService bas = new BankaccServImpl();
		try {
			System.out.println(bas.getAccountById(id));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void transferFunds(Scanner scanner) {
		System.out.println("Enter your account id : ");
		int id1 = scanner.nextInt();
		System.out.println("Enter account id where u want to transfer funds : ");
		int id2 = scanner.nextInt();
		System.out.println("Enter the amount to transfer from account 1 to account 2 :");
		int amt = scanner.nextInt();
		BankAccountService bas = new BankaccServImpl();
		try {
			System.out.println(bas.transferFunds(id1, id2, amt));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("1. Create Account");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Get Account by ID");
			System.out.println("5. Transfer funds to other account.");
			System.out.println("6. Exit");
			System.out.print("Enter your choice (1-6): ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				createAccount(scanner);
				break;
			case 2:
				deposit(scanner);
				break;
			case 3:
				withdraw(scanner);
				break;
			case 4:
				getAccountById(scanner);
				break;
			case 5:
				transferFunds(scanner);
				break;
			case 6:
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 6);
		scanner.close();
	}

}
