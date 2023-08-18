package in_class_examples;

import java.util.ArrayList;
import java.util.List;

interface FindSomething {
	List<Integer> check(List<Integer> ls);
}

public class LamdaEx2 {
	public static void main(String[] args) {
		
		FindSomething f1 = l -> {
			List<Integer> ls = new ArrayList<>();
			for (Integer i : l) {
				if (i % 2 == 0) {
					ls.add(i);
				}
			}
			return ls;
		};
		
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		System.out.println(f1.check(l));
	}
}
