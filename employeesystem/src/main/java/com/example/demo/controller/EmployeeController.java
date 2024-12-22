package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.EmployeeEntity;
import com.example.demo.service.EmployeeServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/employees/v1")
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl eService;

	@PostMapping("/employee/create")
	public EmployeeEntity createEmployee(@RequestBody EmployeeEntity Employee) {
		return eService.createEmployee(Employee);
	}

	@GetMapping("/employee/allemployees")
	public List<EmployeeEntity> getAllEmployees() {
		return eService.getAllEmployees();
	}

	@GetMapping("/employee/{employeeid}")
	public EmployeeEntity getEmployeeById(@PathVariable Long employeeid) {
		return eService.getEmployeeById(employeeid);
	}

	@PutMapping("/employee/{employeeid}/{updatedEmail:.+}")
	public EmployeeEntity updateEmployeeByEmail(@PathVariable("employeeid") Long employeeid,
			@PathVariable("updatedEmail") String updatedEmail) {
		return eService.updateEmployeeByEmail(employeeid, updatedEmail);
	}

	@PutMapping("/employee/{employeeid}")
	public EmployeeEntity updateEmployee(@PathVariable Long employeeid,
			@RequestBody EmployeeEntity updatedmployee) {
		return eService.updateEmployee(employeeid, updatedmployee);
	}

	@DeleteMapping("/employee/{employeeid}")
	public void deleteEmployee(@PathVariable("employeeid") Long employeeid) {
		eService.deleteEmployee(employeeid);
	}
}
