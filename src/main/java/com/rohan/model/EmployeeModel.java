package com.rohan.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
	@Id
	private Integer empId;
	private String empName;
	private String empCity;
	private String empType;
}
