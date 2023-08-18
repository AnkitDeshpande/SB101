package in_class_examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
	private int rollNo;
	private String name;
	private int marks;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int rollNo, String name, int marks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + "]";
	}

}

public class LamdaEx4 {
	public static void main(String[] args) {
		List<Student> st = new ArrayList<>();
		st.add(new Student(1, "Ankit", 850));
		st.add(new Student(2, "Sasnket", 650));
		st.add(new Student(3, "Ravi", 750));
		st.add(new Student(4, "Kishore", 550));
		st.add(new Student(5, "Balu", 450));

		System.out.println("Before Sorting : " + st);

		Collections.sort(st, (s1, s2) -> s1.getMarks() > s2.getMarks() ? -1 : 1);
		System.out.println(st);
		
		Collections.sort(st, (s1, s2)->s1.getName().compareTo(s2.getName()));
		System.out.println(st);
	}
}
