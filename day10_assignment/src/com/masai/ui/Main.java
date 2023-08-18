package com.masai.ui;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import com.masai.dto.Medicine;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.service.IMedicineService;
import com.masai.service.MedicineServiceImp;

public class Main {

	private static void add(Scanner sc) {
		System.out.println("Enter medicine Id.");
		String id = sc.next();
		System.out.println("Enter medicine name.");
		String name = sc.next();
		System.out.println("Enter medical company.");
		String company = sc.next();
		System.out.println("Enter price/Unit.");
		double price = sc.nextDouble();
		System.out.println("Enter manufacturing date in (YYYY-MM-DD) format.");
		LocalDate mfgDate = LocalDate.parse(sc.next());  
		System.out.println("Enter Expiray date in (YYYY-MM-DD) format.");
		LocalDate expDate = LocalDate.parse(sc.next());
		
		
		Medicine med = new Medicine(id, name, company, price, mfgDate, expDate); 
		
		IMedicineService medServ = new MedicineServiceImp();
		try {
			medServ.addMedicine(med);
			System.out.println("Medicine Added Successfully.");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void update(Scanner sc) {
		System.out.println("Enter medicine Id.");
		String id = sc.next();
		System.out.println("Enter medicine name.");
		String name = sc.next();
		System.out.println("Enter medical company.");
		String company = sc.next();
		System.out.println("Enter price/Unit.");
		double price = sc.nextDouble();
		System.out.println("Enter manufacturing date in (YYYY-MM-DD) format.");
		LocalDate mfgDate = LocalDate.parse(sc.next());  
		System.out.println("Enter Expiray date in (YYYY-MM-DD) format.");
		LocalDate expDate = LocalDate.parse(sc.next());
		
		Medicine med = new Medicine(id, name, company, price, mfgDate, expDate);
		
		IMedicineService medServ = new MedicineServiceImp();
		
		try {
			medServ.updateMedicine(med, id);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void delete(Scanner sc) {
		System.out.println("Enter medicine Id.");
		String id = sc.next();
		
		IMedicineService medServ = new MedicineServiceImp();
		try {
			medServ.deleteMedicine(id);
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void view(Scanner sc) {
		IMedicineService medServ  = new MedicineServiceImp();
		try {
			
			System.out.println("1. View All Medicines.");
			System.out.println("2. Search a Medicine. ");
			System.out.println("3. Search Expired Medicines. ");
			System.out.println("Enter Your selection. ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1: 
					medServ.getAllMedicines().stream().forEach(System.out::println);
					break;
				case 2: 
					System.out.println("Enter Medicine ID.");
					String id = sc.next();
					System.out.println(medServ.getMedicineById(id));
					break;
				case 3:
					medServ.getExpiredMedicines().stream().forEach(System.out::println);
					break;
				default:
			}
			
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			System.out.println("1. Add medicine.");
			System.out.println("2. Update Medicine.");
			System.out.println("3. Delete Medicine.");
			System.out.println("4. View all medicines");

			ch = sc.nextInt();

			switch (ch) {
			case 0:
				System.out.println("Buh-bye");
				break;
			case 1:
				add(sc); //done
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
			default:
				System.out.println("Invalid Entry.");
			}

		} while (ch != 0);

		sc.close();
	}

}
