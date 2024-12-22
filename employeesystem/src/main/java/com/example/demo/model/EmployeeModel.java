package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class EmployeeModel {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class EmployeeEntity {
		private long employeeId;
		private String employeeName;
		private String email;
		private String address;
	}
}
