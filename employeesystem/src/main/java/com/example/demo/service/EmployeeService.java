package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.EmployeeEntity;

public interface EmployeeService {

	public EmployeeEntity createEmployee( EmployeeEntity Employee);
	public EmployeeEntity getEmployeeById(Long EmployeeId); 
	public void deleteEmployee(Long EmployeeId); 
	public List<EmployeeEntity> getAllEmployees();
	public EmployeeEntity updateEmployeeByEmail(Long employeeid, String updatedEmail);
	public EmployeeEntity updateEmployeeByEmail(Long employeeid, EmployeeEntity updatedEmail);
}
