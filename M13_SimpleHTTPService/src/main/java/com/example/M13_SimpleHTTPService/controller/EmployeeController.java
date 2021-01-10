package com.example.M13_SimpleHTTPService.controller;

import java.util.List;

import javax.servlet.ServletException;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.HttpStatus;

import com.example.M13_SimpleHTTPService.dto.Employee;
import com.example.M13_SimpleHTTPService.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController { // class that controls the entire application

	@Autowired
	EmployeeService service; // service instance

	// Create a new Employee in data base by path "/api/employees". @param employee by json format. @return inserted employee.
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return service.createEmployee(employee);
	}
	
	// Read all employees from DataBase. @return list of employees.
	@GetMapping("/employees")
	public List<Employee> readAllEmployee() {
		return service.readAllEmployee();
	}

	// Read 1 employee from DataBase by ID. @param id number. @return employee object. 
	@GetMapping("/employees/{id}")
	public Employee readById(@PathVariable(name = "id") Long id) {
		return service.readById(id);
	}

	// Read 1 employee from DataBase by NAME. @param name string. @return employee object. 
	@GetMapping("/employees/name/{name}")
	public List<Employee> readByName(@PathVariable(name = "name") String name) {
		return service.readByName(name);
	}

	// Read 1 employee from DataBase by JOB. @param job string. @return employee object. 
	@GetMapping("/employees/job/{job}")
	public List<Employee> readByJob(@PathVariable(name = "job") String job) {
		return service.readByJob(job);
	}

	// Update 1 employee from DataBase by ID. @param id number. @param employeeUpdated by json format. @return that employee object updated.  
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable(name = "id") Long id, @RequestBody Employee employeeUpdated) {
		Employee employeeToUpdate = service.readById(id);
		employeeToUpdate.setName(employeeUpdated.getName());
		employeeToUpdate.setJob(employeeUpdated.getJob());
		return service.updateEmployee(employeeToUpdate);
	}

	// Delete 1 employee from DataBase by ID. @param id number. 
	@DeleteMapping("/employees/{id}")
	public void deleteById(@PathVariable(name = "id") Long id) {
		service.deleteById(id);
	}
	
}