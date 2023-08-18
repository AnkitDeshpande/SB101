package com.masai;

import java.util.function.Consumer;

public class ConsumerEx implements Consumer<Integer>{

	@Override
	public void accept(Integer t) {
		System.out.println(t+20);
	}
	
}
