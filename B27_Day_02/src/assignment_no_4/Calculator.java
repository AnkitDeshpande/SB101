package assignment_no_4;

import java.util.Scanner;

@FunctionalInterface
interface addition {
	public int sum(int a, int b);
}

@FunctionalInterface
interface subtr {
	public int minus(int a, int b);
}

@FunctionalInterface
interface multi {
	public int mul(int a, int b);
}

@FunctionalInterface
interface divis {
	public int div(int a, int b);
}

public class Calculator {

	private static void add(int n, int m) throws Exception {
		addition a = (l, k) -> l + k;
		System.out.println(a.sum(n, m));
	}

	private static void sub(int n, int m) {
		subtr s = (a, b) -> Math.abs(a - b);
		System.out.println(s.minus(n, m));
	}

	private static void multiply(int n, int m) {
		multi m1 = (a, b) -> m * n;
		System.out.println(m1.mul(n, m));
	}

	private static void div(int n, int m) {
		divis d1 = (a, b) -> Math.max(a, b) / Math.min(a, b);
		System.out.println(d1.div(n, m));
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int ch = 0;
		do {
			System.out.println("Enter your choice : ");
			System.out.println("1. addition");
			System.out.println("2. Subtraction");
			System.out.println("3. Multiplication");
			System.out.println("4. Division");
			System.out.println("0. exit");

			ch = sc.nextInt();

			switch (ch) {
			case 1:
				try {
					System.out.println("Enter the first number :");
					int n = sc.nextInt();
					System.out.println("Enter the second number :");
					int m = sc.nextInt();
					add(n, m);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					System.out.println("Enter the first number :");
					int n = sc.nextInt();
					System.out.println("Enter the second number :");
					int m = sc.nextInt();
					sub(n, m);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					System.out.println("Enter the first number :");
					int n = sc.nextInt();
					System.out.println("Enter the second number :");
					int m = sc.nextInt();
					multiply(n, m);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					System.out.println("Enter the first number :");
					int n = sc.nextInt();
					System.out.println("Enter the second number :");
					int m = sc.nextInt();
					if (n == 0 || m == 0) {
						throw new Exception("A number cant be divide or divisible by 0");
					}
					div(n, m);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 0:
				System.out.println("Bye - bye");
				break;
			default:
				throw new Exception("Invalid Input");
			}

		} while (ch != 0);
	}

}
