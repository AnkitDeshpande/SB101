package in_class_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StringCompare implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);
	}
	
}

public class LamdaEx3 {
	public static void main(String[] args) {
		List<String> ls = Arrays.asList("Java", "Javascript", "Ankit");
		System.out.println("Before Sorting :"+ ls);
		Collections.sort(ls, new StringCompare());
		System.out.println("After Sorting :"+ls);
		
		Comparator<String> c1 = (s1, s2) -> s2.compareTo(s1);
		Collections.sort(ls, new StringCompare());
		System.out.println(ls);
	}
}
