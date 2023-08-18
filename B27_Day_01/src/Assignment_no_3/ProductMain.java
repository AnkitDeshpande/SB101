package Assignment_no_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductMain {
	public static void main(String[] args) {
		List<Product> p1 = new ArrayList<>();

		p1.add(new Product(101, "Shreekhand", 150, 160));
		p1.add(new Product(102, "Ice-Cream", 170, 30));
		p1.add(new Product(104, "Shreekhand", 150, 160));
		p1.add(new Product(105, "Milk-bags", 230, 25));
		p1.add(new Product(103, "Good-day biscuits", 100, 10));
		p1.add(new Product(108, "Ice-Cream", 170, 30));
		p1.add(new Product(107, "Gulab-jamun", 170, 30));
		p1.add(new Product(106, "Good-day biscuits", 100, 10));

		Collections.sort(p1, new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				if (o1.getPrice() == o2.getPrice()) {
					if (o1.getQuantity() == o2.getQuantity()) {
						if (o1.getProductName().compareTo(o2.getProductName()) == 0) {
							if(o1.getProductId()>o2.getProductId()) {
								return -1;
							}else {
								return 1;
							}
						} else {
							return o2.getProductName().compareTo(o1.getProductName());
						}
					} else if (o1.getQuantity() > o2.getQuantity()) {
						return -1;
					} else {
						return 1;
					}
				} else if (o1.getPrice() > o2.getPrice()) {
					return -1;
				} else {
					return 1;
				}
			}

		});

		for (Product product : p1) {
			System.out.println(product);
		}
	}
}
