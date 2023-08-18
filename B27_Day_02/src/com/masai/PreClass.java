package com.masai;

import java.util.function.Predicate;

public class PreClass implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		if(t>0) {
			return true;
		}
		return false;
	}

}
