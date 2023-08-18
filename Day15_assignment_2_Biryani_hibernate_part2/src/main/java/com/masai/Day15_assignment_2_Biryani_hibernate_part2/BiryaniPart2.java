package com.masai.Day15_assignment_2_Biryani_hibernate_part2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BiryaniPart2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int BiryaniId;
	private int rating;

	public BiryaniPart2() {
		super();
	}

	public BiryaniPart2(int rating) {
		super();
		this.rating = rating;
	}

	public int getBiryaniId() {
		return BiryaniId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Biryani [BiryaniId=" + BiryaniId + ", rating=" + rating + "]";
	}

}
