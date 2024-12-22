package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entities.EmployeeEntity;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class EmployeeServiceImpl {
	@Autowired
	private EmployeeDao EmployeeDao;

	public EmployeeEntity createEmployee(EmployeeEntity Employee) {
		return EmployeeDao.save(Employee);
	}

	public EmployeeEntity getEmployeeById(Long employeeid) {
		return EmployeeDao.findById(employeeid).orElseThrow(() ->  new ResourceNotFoundException("employee not found with id"+employeeid));
	}

	public void deleteEmployee(Long employeeid) {
		EmployeeDao.deleteById(employeeid);
	}

	public List<EmployeeEntity> getAllEmployees() {
		return (List<EmployeeEntity>) EmployeeDao.findAll();
	}

	public EmployeeEntity updateEmployee(Long employeeid, EmployeeEntity updatedEmployee) {
		EmployeeEntity EmployeeFromdB = EmployeeDao.findById(employeeid).get();
		EmployeeFromdB.setAddress(updatedEmployee.getAddress());
		EmployeeFromdB.setEmail(updatedEmployee.getEmail());
		EmployeeFromdB.setEmployeeName(updatedEmployee.getEmployeeName());
		return EmployeeDao.save(EmployeeFromdB);
	}

	public EmployeeEntity updateEmployeeByEmail(Long employeeid, String updatedEmail) {
		EmployeeEntity EmployeeFromdB = EmployeeDao.findById(employeeid).orElseThrow(() ->  new ResourceNotFoundException("employee not found with id"+employeeid));
		EmployeeFromdB.setEmail(updatedEmail);
		return EmployeeDao.save(EmployeeFromdB);
	}
}
