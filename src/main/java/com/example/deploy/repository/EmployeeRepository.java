package com.example.deploy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.deploy.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {
	

}
