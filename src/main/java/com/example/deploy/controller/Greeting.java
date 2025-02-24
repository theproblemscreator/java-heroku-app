package com.example.deploy.controller;

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

import com.example.deploy.model.Employee;
import com.example.deploy.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class Greeting {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/records")
	public List<Employee> getAllRecords() {
		return employeeService.getAllRecords();

	}

	@PostMapping("/save")
	public Employee saveRecord(@RequestBody Employee emp) {
		return employeeService.saveRecord(emp);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		employeeService.deleteUser(id);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable Long id) {

		return employeeService.updateEmployee(id, emp);

	}
}
