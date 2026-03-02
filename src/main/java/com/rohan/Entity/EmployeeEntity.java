package com.rohan.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
	@Id
	private Integer empId;
	private String empName;
	private String empCity;
	private String empType;
}
