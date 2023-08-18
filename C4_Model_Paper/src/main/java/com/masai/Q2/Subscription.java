package com.masai.Q2;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Subscription {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "plan_name", nullable = false)
    private String planName;

    @Column(name = "number_of_channels", nullable = false)
    private int numberOfChannels;

    @Column(name = "monthly_charges", nullable = false)
    private double monthlyCharges;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	 public Subscription(String planName, int numberOfChannels, double monthlyCharges, LocalDate startDate, LocalDate endDate) {
	        this.planName = planName;
	        this.numberOfChannels = numberOfChannels;
	        this.monthlyCharges = monthlyCharges;
	        this.startDate = startDate;
	        this.endDate = endDate;
	    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public int getNumberOfChannels() {
		return numberOfChannels;
	}

	public void setNumberOfChannels(int numberOfChannels) {
		this.numberOfChannels = numberOfChannels;
	}

	public double getMonthlyCharges() {
		return monthlyCharges;
	}

	public void setMonthlyCharges(double monthlyCharges) {
		this.monthlyCharges = monthlyCharges;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", planName=" + planName + ", numberOfChannels=" + numberOfChannels
				+ ", monthlyCharges=" + monthlyCharges + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}
