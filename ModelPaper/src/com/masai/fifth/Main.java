package com.masai.fifth;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

class Applicant {
	private String applicantId;
	private String name;
	private double interviewMarks;

	public Applicant(String applicantId, String name, double interviewMarks) {
		this.applicantId = applicantId;
		this.name = name;
		this.interviewMarks = interviewMarks;
	}

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getInterviewMarks() {
		return interviewMarks;
	}

	public void setInterviewMarks(double interviewMarks) {
		this.interviewMarks = interviewMarks;
	}

	public String toString() {
		return "Applicant [applicantId=" + applicantId + ", name=" + name + ", interviewMarks=" + interviewMarks + "]";
	}
}

class Employee {
	private String employeeId;
	private String name;
	private String designation;
	private double salary;

	public Employee(String employeeId, String name, String designation, double salary) {
		this.employeeId = employeeId;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", designation=" + designation + ", salary="
				+ salary + "]";
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Applicant> ls = new ArrayList<>();
		ls.add(new Applicant("A100130", "Ankit", 86.0));
		ls.add(new Applicant("A120360", "Sanket", 70.5));
		ls.add(new Applicant("A255140", "Balu", 90.34));
		ls.add(new Applicant("A536458", "Ravi", 60.56));
		ls.add(new Applicant("A987235", "Snehal", 50.36));
		
		ls.stream().map(a -> {
		    Employee e = null;
		    double interviewMarks = a.getInterviewMarks();
		    if (interviewMarks >= 85) {
		        double salary = 60000 + (50 * interviewMarks);
		        e = new Employee(a.getApplicantId(), a.getName(), "Manager", salary);
		    } else if (interviewMarks >= 65) {
		        double salary = 35000 + (30 * interviewMarks);
		        e = new Employee(a.getApplicantId(), a.getName(), "Clerk", salary);
		    } else if (interviewMarks >= 50) {
		        double salary = 25000 + (20 * interviewMarks);
		        e = new Employee(a.getApplicantId(), a.getName(), "Junior Clerk", salary);
		    }
		    return e;
		}).collect(Collectors.toList()).forEach(x->System.out.print(x+"\n"));
		
	}

}
