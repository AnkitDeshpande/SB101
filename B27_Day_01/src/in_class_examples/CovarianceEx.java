package in_class_examples;

import java.util.ArrayList;
import java.util.List;

public class CovarianceEx {
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(20);
		intList.add(30);
		intList.add(40);
		intList.add(50);
		
		List<? extends Number> numList =  intList;
		for(Number n : numList) {
			System.out.print(n + " ");
		}
		
		//numList.add(34);        --------> not allowed because in covaraince reading is allowed but writing is not allowed.
	}
}
