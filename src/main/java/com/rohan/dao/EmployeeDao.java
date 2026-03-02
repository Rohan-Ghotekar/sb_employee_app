package com.rohan.dao;

import java.util.List;
import java.util.Optional;
import com.rohan.Entity.EmployeeEntity;

public interface EmployeeDao {


	Integer addEmployees(List<EmployeeEntity> employees);
	List<EmployeeEntity> getEmployeeByCityAndName(String name, String city);
	List<EmployeeEntity> getEmployeeByCity(String city);
	List<EmployeeEntity> getEmployeeByName(String name);
	List<EmployeeEntity> getEmployeeByType(String type);
	List<EmployeeEntity> getAllEmployees();
	Optional<EmployeeEntity> getEmployeeById(Integer empId);
	boolean employeeExistById(Integer id);
	void deleteEmployeeById(Integer empId);
	void updateEmployee(EmployeeEntity employee);
}