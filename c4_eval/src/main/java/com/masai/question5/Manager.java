package com.masai.question5;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private LocalDate joining_date;

	@ManyToMany(mappedBy = "managers", cascade = CascadeType.ALL)
	private Set<Project> projects;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, LocalDate joining_date, Set<Project> projects) {
		super();
		this.name = name;
		this.joining_date = joining_date;
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", joining_date=" + joining_date + ", projects=" + projects
				+ "]";
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

	public LocalDate getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(LocalDate joining_date) {
		this.joining_date = joining_date;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

}
