package com.assignment;

import java.util.*;

class Product {
	private int productId;
	private String productName;
	private int quantity;
	private int price;

	public Product(int productId, String productName, int quantity, int price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

}

public class ProductDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Product> p1 = new ArrayList<>();

		p1.add(new Product(101, "Shreekhand", 50, 160));
		p1.add(new Product(102, "Ice-Cream", 170, 30));
		p1.add(new Product(101, "Chavanprash", 150, 180));
		p1.add(new Product(101, "Milk-bags", 230, 25));
		p1.add(new Product(101, "Good-day biscuits", 100, 10));
		// p1.add(new Product(107, "Ice-Cream", 170, 30));
		// p1.add(new Product(107, "Gulab-jamun", 170, 30));
		// p1.add(new Product(106, "Good-day biscuits", 100, 10));

		Collections.sort(p1, new Comparator<Product>() {
			public int compare(Product pr1, Product pr2) {
				if (pr1.getPrice() == pr2.getPrice()) {
					if (pr1.getQuantity() == pr2.getQuantity()) {
						if (pr2.getProductName().compareTo(pr1.getProductName()) == 0) {
							if (pr1.getProductId() > pr2.getProductId()) {
								return -1;
							} else if (pr1.getProductId() < pr2.getProductId()) {
								return 1;
							} else {
								return 0;
							}
						} else {
							return pr2.getProductName().compareTo(pr1.getProductName());
						}
					} else if (pr2.getQuantity() > pr1.getQuantity()) {
						return 1;
					} else {
						return -1;
					}
				} else if (pr2.getPrice() > pr1.getPrice()) {
					return 1;
				} else {
					return -1;
				}
			}
		});

		for (Product product : p1) {
			System.out.println(product);
		}
	}

}
