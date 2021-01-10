package com.example.M13_SimpleHTTPService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.M13_SimpleHTTPService.dto.Employee;

//Data Access Object. Extends JpaRepository by Employee and Long id parameters. Creates findByJob and findByName.
 
public interface IEmployeeDAO extends JpaRepository<Employee, Long> {

	public List<Employee> findByJob(String job); 

	public List<Employee> findByName(String name); 

}