package com.example.M13_SimpleHTTPService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.M13_SimpleHTTPService.dto.Employee;
import com.example.M13_SimpleHTTPService.dao.IEmployeeDAO;

@Service
public class EmployeeService {

	@Autowired
	IEmployeeDAO iEmployeeDAO;
	
	// Create new employee
	public Employee createEmployee(Employee employee) { 
		return iEmployeeDAO.save(employee);
	}

	// Read all employees
	public List<Employee> readAllEmployee() { 
		return iEmployeeDAO.findAll();
	}
	
	// Read 1 employee by ID
	public Employee readById(Long id) { 
		return iEmployeeDAO.findById(id).get();
	}
	
	// Read 1 employee by name
	public List<Employee> readByName(String name) { 
		return iEmployeeDAO.findByName(name);
	}
	
	// Read 1 employee by job
	public List<Employee> readByJob(String job) { 
		return iEmployeeDAO.findByJob(job);
	}
	
	// Update 1 employee by ID
	public Employee updateEmployee(Employee employee) { 
		return iEmployeeDAO.save(employee);
	}
	
	// Delete 1 employee by ID
	public void deleteById(Long id) { 
		iEmployeeDAO.deleteById(id);
	}

}