package com.masai.Question2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 * (i) Create a functional interface whose method takes parameter of type Object[] but
return object of class Customer. The array of Object contains id, name, email and state
for Customer. Make sure to use a suitable annotation as well.
 */

@FunctionalInterface
interface fun {
	public Customer createCustomer(Object[] arr); // 1.
}

public class PartA {
	public static void main(String[] args) {
		/*
		 * (ii) Write an implementation of the above functional interface using a lambda
		 * function.
		 */
		fun f = arr -> {
			return new Customer((Integer) arr[0], (String) arr[1], (String) arr[2], (String) arr[3]); // 2.
		};

		List<Customer> list = new ArrayList<>();
		Object[][] obj = new Object[][] { { 1, "ABC", "abc@gmail.com", "Punjab" },
				{ 2, "BCD", "bcd@gmail.com", "Haryana" }, { 3, "CDE", "cde@gmail.com", "Karnataka" },
				{ 4, "DEF", "def@yahoo.com", "Punjab" }, { 5, "EFG", "efg@masai.com", "Karnataka" } };

		/*
		 * (iii) Create a List of Customer type and add 5 objects to it. The objects of
		 * the Customer class should be taken from the lambda expression implemented
		 * above. You can use
		 */
		for (Object customer : obj) {
			list.add(f.createCustomer((Object[]) customer)); // 3
		}

		list.stream().forEach(ct -> System.out.println(ct));
		System.out.println();

		// difficulty in 4.
		/*
		 * (iv) Write an implementation of the Supplier functional interface using a
		 * lambda expression that returns any random state name from state array
		 * {"Punjab", "Karnataka", "Haryana"}. Print the total number of Customers from
		 * the state returned by the Supplier in
		 * "From <state> we have <count> customers" format.
		 * 
		 */

		/*
		 * (v) Write an implementation of the Function Functional interface using a
		 * lambda function that takes a List of Customer as a parameter and returns a
		 * Map that has state as the key and Customer(s) from that state as the value.
		 * 
		 */
		Map<String, List<Customer>> customerMap = new HashMap<>();

		Function<List<Customer>, Map<String, List<Customer>>> function = ct -> ct.stream()
				.collect(Collectors.groupingBy(t -> t.getState()));
		customerMap = function.apply(list);
		customerMap.forEach((t, u) -> {
			System.out.println("state : " + t + " : " + "List :");
			u.forEach(System.out::println);
		});
		System.out.println(); // 5

		/*
		 * (vi) Write an implementation of the BiConsumer interface using a lambda
		 * function for the map produced from above step such that this implementation
		 * prints the state and the total number of customers with from that state.
		 */
		BiConsumer<String, List<Customer>> bc = (st, list2) -> System.out.println(st + " : " + list2.size());
		customerMap.forEach(bc);
		System.out.println(); // 6

		/*
		 * (vii) Write an implementation of the Consumer functional interface using a
		 * lambda function to print the Customer details in the form "<name> with id
		 * <id> has email <email> and lives in <state>.”
		 */

		Consumer<List<Customer>> c2 = lst -> lst.stream().forEach(t -> System.out.println(t.getName() + " with id "
				+ t.getId() + " has email " + t.getEmail() + " and lives in " + t.getState()));
		c2.accept(list);
		System.out.println();// 7

		/*
		 * (viii) Write an implementation of the Predicate functional interface using a
		 * lambda expression that returns true if any customer's email address ends with
		 * "@masai.com"; false otherwise. Print the details consumer objects for which
		 * predicate return true. print the details in the same format as specified
		 * above.
		 */
		Predicate<Customer> emailPredicate = customer -> customer.getEmail().endsWith("@masai.com");

		list.stream().filter(emailPredicate).forEach(t -> System.out.println(t.getName() + " with id " + t.getId()
				+ " has email " + t.getEmail() + " and lives in " + t.getState()));
		System.out.println();

		/*
		 * (ix) Write implemetation of the BiFunction functional interface using a
		 * lambda expression that returns List of name of customer from List of customer
		 * if state of scholar contains all characters of a text (may/may not be
		 * continous). The List of customers and text should be parameter for apply
		 * method and List of name of customer should be return from this method. - Say
		 * text is "ua" then it will display name of Students from Punjab - Say text is
		 * "rn" then it will display name of Students from Haryana & Karnataka
		 */

		BiFunction<List<Customer>, String, List<String>> biFn = (lst, str) -> {
			List<String> names = new ArrayList<>();
			for (Customer c : list) {
				String state = c.getState();
				char ch[] = "ua".toCharArray();
				boolean containsAll = true;

				for (char cr : ch) {
					if (state.indexOf(cr) == -1) {
						/* System.out.println(cr + " Not found"); */
						containsAll = false;
						break;
					}
				}
				if (containsAll) {
					names.add(c.getName());
				}
			}
			return names;
		};

		biFn.apply(list, "ua").forEach(System.out::println);
		System.out.println();

	}
}
