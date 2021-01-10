package com.example.M13_SimpleHTTPService.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Data Transfer Object. Enum inner class to define job and salary variables.

@Entity
@Table(name = "employee")
public class Employee {

	//Class entity attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "job")
	private String job;
	@Column(name = "salary")
	private double salary;

	//constructors
	public Employee() {
	}

	public Employee(Long id, String name, String job) {
		this.id = id;
		this.name = name;
		CAREER career = toCareer(job);
		this.job = career.getPosition();
		this.salary = career.getSalary();
	}

	//getters
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

	public double getSalary() {
		return salary;
	}

	//setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setJob(String job) {
		CAREER career = toCareer(job);
		this.job = career.getPosition();
		this.salary = career.getSalary();
	}

	//To String
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", job=" + job + ", salary=" + salary + "]";
	}

	//param role string: select the first letter, convert it to a capital letter and submit to the method valueOf
	//return CAREER Enum class object, if you don't find a valid option it returns an error enum X with values "Error" to job and 0.0 to salary.
	private CAREER toCareer(String role) {
		try {
			return CAREER.valueOf(role.substring(0, 1).toUpperCase());
		} catch (Exception e) {
			System.out.println("Error: not valid position");
			return CAREER.X;
		}
	}
	
	//Private Inner Class. F for Front, B for Back, D for Data and X for Error.
	private enum CAREER {
		// definition of possibles careers and salaries.
		F("Front", 1400.0), B("Back", 1500.0), D("Data", 1600.0), X("Error", 0.0);

		// constructor
		private CAREER(String position, double salary) {
			this.position = position;
			this.salary = salary;
		}

		// getters
		public String getPosition() {
			return position;
		}

		public double getSalary() {
			return salary;
		}

		// variables
		private String position;
		private double salary;
	}

}