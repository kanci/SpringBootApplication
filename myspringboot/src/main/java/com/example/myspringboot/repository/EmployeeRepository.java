package com.example.myspringboot.repository;

//repository can it be for dao package?

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.myspringboot.entity.Employee;


@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
