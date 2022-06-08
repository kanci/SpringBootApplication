package com.example.myspringboot.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myspringboot.entity.Employee;

import com.example.myspringboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository=theEmployeeRepository;
	}

	@Override
	@Transactional//???maybe
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	@Transactional//??maybe
	public Employee findById(int theId) {
		Optional<Employee> result=employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee=result.get();
			
		}
		else {
			//we didn't find the employee
			throw new RuntimeException("Did not find employee id - "+theId);
		}
		return theEmployee;
	}

	@Override
	@Transactional//???maybe
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
		
	}

	@Override
	@Transactional//????maybe
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
		
	}
}
