package com.assignment;

import java.util.List;
import java.util.ArrayList;

class Student {
	private int rollno;
	private String name;
	private String state;

	public Student(int rollno, String name, String state) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.state = state;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Student[" + "rollNo=" + rollno + ", name='" + name + '\'' + ", state='" + state + '\'' + ']'+"\n";
	}

}

class SchoolStudent extends Student {
	private String boardName;

	public SchoolStudent(int rollno, String name, String state, String boardName) {
		super(rollno, name, state);
		// TODO Auto-generated constructor stub
		this.boardName = boardName;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	@Override
	public String toString() {
		return "SchoolStudent[" + "rollNo=" + getRollno() + ", name='" + getName() + '\'' + ", state='" + getState()
				+ '\'' + ", boardName='" + boardName + '\'' + ']'+"\n";
	}

}

class CollegeStudent extends Student {
	private String universityName;

	public CollegeStudent(int rollno, String name, String state, String universityName) {
		super(rollno, name, state);
		// TODO Auto-generated constructor stub
		this.universityName = universityName;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	@Override
	public String toString() {
		return "CollegeStudent[" + "rollNo=" + getRollno() + ", name='" + getName() + '\'' + ", state='" + getState()
				+ '\'' + ", universityName='" + universityName + '\'' + ']'+"\n";
	}
}

public class SameState {

	public static void findStudentWithSameState(List<Student> result, List<? extends Student> s1, List<? extends Student> s2,
			String state) {
		for (Student st1 : s1) {
			if (st1.getState().equals(state)) {
				result.add(st1);
			}
		}
		for (Student st2 : s2) {
			if (st2.getState().equals(state)) {
				result.add(st2);
			}
		}
	}

	public static void main(String[] args) {
		List<SchoolStudent> ss1 = new ArrayList<>();
		ss1.add(new SchoolStudent(1, "Ankit", "Maharashtra", "State Board"));
		ss1.add(new SchoolStudent(2, "Sanket", "Maharashtra", "State Board"));
		ss1.add(new SchoolStudent(3, "Shubham", "Bihar", "CBSE"));
		ss1.add(new SchoolStudent(4, "Harpreet", "Punjab", "ICSE"));
		ss1.add(new SchoolStudent(5, "Balu", "Maharashtra", "State Board"));
		
		
		List<CollegeStudent> cs1 = new ArrayList<>();
		cs1.add(new CollegeStudent(1, "Mayur", "Maharashtra", "DBATU"));
		cs1.add(new CollegeStudent(2, "Virat", "Delhi", "Delhi University"));
		cs1.add(new CollegeStudent(3, "Rohit", "Telangana", "Telengana University"));
		cs1.add(new CollegeStudent(4, "Dhoni", "Jharkhand", "Jharkhand University"));
		cs1.add(new CollegeStudent(5, "Ravi", "Maharashtra", "BAMU"));
		
		List<Student> resultList = new ArrayList<>();
		findStudentWithSameState(resultList, ss1, cs1, "Maharashtra");
		
		System.out.println(resultList);
	}
}
