package Assignment_no_1;

import java.util.Scanner;

public class StackMain {
	public static void main(String[] args) throws Exception {

		Stack<String> stack = new Stack<>();

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Peek");
			System.out.println("4. Is Empty");
			System.out.println("5. Show");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter element to push: ");
				String element = sc.next();
				stack.push(element);
				break;
			case 2:
				try {
					String popped = stack.pop();
					System.out.println("Popped element : " + popped);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error : " + e.getMessage());
				}
				break;
			case 3:
				try {
					String peeked = stack.peek();
					System.out.println("Peeked element: " + peeked);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error : " + e.getMessage());
				}
				break;
			case 4:
				System.out.println("Is stack empty? " + stack.isEmpty());
				break;
			case 5:
				try {
					System.out.println("Elements of stack:");
					stack.show();	
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error : " + e.getMessage());
				}
				break;
			case 6:
				System.exit(0);
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
			System.out.println();
		}
	}
}
