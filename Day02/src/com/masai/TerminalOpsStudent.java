package com.masai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalOpsStudent {
	public static void main(String[] args) {
		List<Integer> ls = Arrays.asList(1, 1, 2, 3, 4, 5);
		List<Student> s = new ArrayList<>();

		s.add(new Student(1, "Ankit", 1000));
		s.add(new Student(2, "sanket", 900));
		s.add(new Student(3, "Balu", 450));
		s.add(new Student(4, "Ravi", 750));
		
		System.out.println(s.stream().filter(i->i.getMarks()<800).map(Student::getMarks).collect(Collectors.toList()));
		System.out.println(ls.stream().skip(2).toList());
		System.out.println(ls.stream().limit(2).toList());
		
		
		Comparator<Student> c = (s1, s2) -> s2.getMarks()-s1.getMarks(); 
		s.stream().sorted(c).forEach(st->System.out.println(st.getRoll()+" "+st.getName()+" "+st.getMarks()));
		System.out.println();
	}
}
