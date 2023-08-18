package com.masai.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.masai.dto.Medicine;
import com.masai.exceptions.NorecordsFoundException;
import com.masai.exceptions.SomethingWentWrongException;
import com.masai.service.MedService;
import com.masai.service.MedicineServiceImpl;

public class MedicineMain {
	private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private static void addMedicine(Scanner scanner) {
		System.out.println("\n--- Add Medicine ---");
		System.out.print("Enter med_id : ");
		String medId = scanner.next();
		System.out.print("Enter medicine name: ");
		String name = scanner.next();
		System.out.print("Enter company name: ");
		String company = scanner.next();
		System.out.print("Enter price per unit: ");
		BigDecimal pricePerUnit = scanner.nextBigDecimal();
		System.out.print("Enter manufacturing date (yyyy-MM-dd): ");
		LocalDate mfgDate = LocalDate.parse(scanner.next(), dateFormatter);
		System.out.print("Enter expiry date (yyyy-MM-dd): ");
		LocalDate expDate = LocalDate.parse(scanner.next(), dateFormatter);

		MedService ms = new MedicineServiceImpl();
		try {
			ms.addMed(new Medicine(medId, name, company, pricePerUnit, mfgDate, expDate));
		} catch (SomethingWentWrongException e) {
			e.printStackTrace();
		}
	}

	private static void updateMedicine(Scanner scanner) {
		System.out.println("\n--- Update Medicine ---");
		System.out.print("Enter med_id of the medicine to update: ");
		String medId = scanner.next();
		System.out.print("Enter medicine name: ");
		String name = scanner.next();
		System.out.print("Enter company name: ");
		String company = scanner.next();
		System.out.print("Enter price per unit: ");
		BigDecimal pricePerUnit = scanner.nextBigDecimal();
		System.out.print("Enter manufacturing date (yyyy-MM-dd): ");
		LocalDate mfgDate = LocalDate.parse(scanner.next(), dateFormatter);
		System.out.print("Enter expiry date (yyyy-MM-dd): ");
		LocalDate expDate = LocalDate.parse(scanner.next(), dateFormatter);

		MedService ms = new MedicineServiceImpl();
		try {
			ms.updateMed(medId, name, company, pricePerUnit, mfgDate, expDate);
		} catch (SomethingWentWrongException | NorecordsFoundException e) {
			e.printStackTrace();
		}

	}

	private static void deleteMedicine(Scanner scanner) {
		System.out.println("\n--- Delete Medicine ---");
		System.out.print("Enter med_id of the medicine to delete: ");
		String medId = scanner.next();

		MedService ms = new MedicineServiceImpl();
		try {
			ms.deleteMed(medId);
		} catch (SomethingWentWrongException | NorecordsFoundException e) {
			e.printStackTrace();
		}
	}

	private static void viewAllMedicines(Scanner scanner) {
		System.out.println("\n--- All Medicines ---");
		MedService ms = new MedicineServiceImpl();

		try {
			List<Medicine> list = ms.viewAllMeds();
			if (list.isEmpty()) {
				System.out.println("No medicines found.");
				return;
			}

			list.stream().sorted((m1, m2) -> m1.getName().compareTo(m2.getName())).collect(Collectors.toList())
					.forEach(System.out::println);

		} catch (SomethingWentWrongException | NorecordsFoundException e) {
			e.printStackTrace();
		}
	}

	private static void searchMedicineById(Scanner scanner) {
		System.out.println("\n--- Search Medicine by med_id ---");
		System.out.print("Enter med_id to search: ");
		String medId = scanner.next();
		MedService ms = new MedicineServiceImpl();
		try {
			List<Medicine> list = ms.viewAllMeds();
			if (list.isEmpty()) {
				System.out.println("No medicines found.");
				return;
			}

			Optional<Medicine> optionalMedicine = list.stream().filter(medicine -> medicine.getMedId().equals(medId))
					.findFirst();

			if (optionalMedicine.isPresent()) {
				Medicine medicine = optionalMedicine.get();
				System.out.println("Medicine found:");
				System.out.println(medicine);
			} else {
				System.out.println("No medicine found with med_id: " + medId);
			}

		} catch (SomethingWentWrongException | NorecordsFoundException e) {
			e.printStackTrace();
		}
	}

	private static void searchExpiredMedicines(Scanner sc) {
		System.out.println("\n--- Search Expired Medicines ---");
		LocalDate currentDate = LocalDate.now();
		MedService ms = new MedicineServiceImpl();
		try {
			List<Medicine> list = ms.viewAllMeds();
			if (list.isEmpty()) {
				System.out.println("No medicines found.");
				return;
			}

			list.stream().filter(m -> m.getExpDate().isBefore(currentDate)).forEach(System.out::println);
		} catch (SomethingWentWrongException | NorecordsFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int choice;

		do {
			System.out.println("\n--- Medicine Management System ---");
			System.out.println("1. Add medicine");
			System.out.println("2. Update medicine details");
			System.out.println("3. Delete medicine");
			System.out.println("4. View all medicines (sorted by name)");
			System.out.println("5. Search medicine by med_id");
			System.out.println("6. Search expired medicines");

			System.out.print("\nEnter your choice (1-6): ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addMedicine(scanner);
				break;
			case 2:
				updateMedicine(scanner);
				break;
			case 3:
				deleteMedicine(scanner);
				break;
			case 4:
				viewAllMedicines(scanner);
				break;
			case 5:
				searchMedicineById(scanner);
				break;
			case 6:
				searchExpiredMedicines(scanner);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);
		scanner.close();
	}

}
