package com.masai.supplier;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;

public class SupplierDemo {
	public static void main(String[] args) {
		Supplier<String> randomID = ()->UUID.randomUUID().toString();
		Supplier<Integer> intRandomID = ()->UUID.randomUUID().hashCode();
		System.out.println(randomID.get());
		System.out.println(randomID.get());
		System.out.println(randomID.get());
		System.out.println(randomID.get());
		
		
		Set<String> id_set = new HashSet<>(); 
		Set<String> int_id_set = new HashSet<>(); 
		
		for(int i=1; i<=10; i++) {
			id_set.add(randomID.get());
		}
	}
}
