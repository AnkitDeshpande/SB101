package com.masai.Question3;

public class Applicant {
	private int applicantId;
	private String name;
	private double interviewMarks;

	public Applicant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Applicant(int applicantId, String name, double interviewMarks) {
		super();
		this.applicantId = applicantId;
		this.name = name;
		this.interviewMarks = interviewMarks;
	}

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
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

	@Override
	public String toString() {
		return "Applicant [applicantId=" + applicantId + ", name=" + name + ", interviewMarks=" + interviewMarks + "]";
	}

}
