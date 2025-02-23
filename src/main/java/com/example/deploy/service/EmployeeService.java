package com.example.deploy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.deploy.model.Employee;
import com.example.deploy.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employee;
	
	public List<Employee> getAllRecords(){
		return employee.findAll();
		
	}
	
	public Employee saveRecord(Employee emp) {
		return employee.save(emp);	
	}
	
	public void deleteUser(Long id) {
		employee.deleteById(id);
	}
	
	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		
		Employee emp = employee.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
		
		emp.setName(updatedEmployee.getName());
		emp.setEmail(updatedEmployee.getEmail());
		return employee.save(emp);
	}
}
