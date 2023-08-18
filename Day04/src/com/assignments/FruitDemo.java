package com.assignments;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Fruit implements Comparable<Fruit> {
	private String name;
	private int quantity;
	private double price;

	public Fruit(String name, int quantity, double price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return price * quantity;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", quantity=" + quantity + ", price=" + price + "]\n";
	}

	@Override
	public int compareTo(Fruit o) {
		// TODO Auto-generated method stub
		if (price < o.price) {
			return -1;
		} else if (price > o.price) {
			return 1;
		}
		return 0;
	}

}

public class FruitDemo {
	public static void main(String[] args) {
		List<Fruit> fruits = Arrays.asList(new Fruit("Orange", 10, 89), new Fruit("Papaya", 20, 90),
				new Fruit("Apple", 10, 45), new Fruit("Watermelon", 10, 56), new Fruit("Guava", 10, 40),
				new Fruit("Pomegranate", 10, 200));
		Map<String, Double> f = fruits.stream().collect(Collectors.toMap(Fruit::getName, Fruit::getTotal));
		System.out.println(f);

		double totalPrice = fruits.stream().mapToDouble(Fruit::getTotal).sum();
		System.out.println("Total price : " + totalPrice);

		List<Fruit> filtered = fruits.stream().filter(i -> i.getTotal() / i.getQuantity() >= 50).sorted().collect(Collectors.toList());
		System.out.println(filtered);
	}
}
