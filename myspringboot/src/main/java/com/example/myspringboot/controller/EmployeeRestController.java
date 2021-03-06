package com.example.myspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myspringboot.entity.Employee;
import com.example.myspringboot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;

	//@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		super();//maybe optional but could be possible..
		employeeService=theEmployeeService;
	}
	
	//expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	//add mapping for GET /employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee==null) {
			throw new EmployeeNotFoundException("Employee id not found - "+employeeId);
		}
		return theEmployee;
	}

	//add mapping for POST /employees - add new employee
	
	@PostMapping("/employees") 
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		//also just in case they pass and id in JSON... set id to 0
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	//add mapping for PUT /employees - update existing employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	//add mapping for DELETE /employees/{employeeId} - delete employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmployee = employeeService.findById(employeeId);
		
		//throw exception if null
		if (tempEmployee==null) {
			throw new EmployeeNotFoundException("Employee id not found - "+employeeId);
		}
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id - "+employeeId;
	}
	
	
}
