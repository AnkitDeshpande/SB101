package com.masai;

import java.util.function.Function;

public class FunctionalEx implements Function<String, Integer>{

	@Override
	public Integer apply(String t) {
		return Integer.parseInt(t);
	}

}
