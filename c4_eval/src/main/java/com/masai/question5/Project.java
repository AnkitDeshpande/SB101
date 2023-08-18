package com.masai.question5;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private int duration;

	@ManyToMany(fetch = FetchType.EAGER)
	// @JoinTable(name = "Project_Manager", joinColumns =
	// @JoinColumn(referencedColumnName = "id"), inverseJoinColumns =
	// @JoinColumn(referencedColumnName = "id"))
	private Set<Manager> managers;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(String name, int duration, Set<Manager> managers) {
		super();
		this.name = name;
		this.duration = duration;
		this.managers = managers;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Set<Manager> getManagers() {
		return managers;
	}

	public void setManagers(Set<Manager> managers) {
		this.managers = managers;
	}

}
