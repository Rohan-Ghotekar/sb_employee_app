package com.rohan.service;

import java.util.List;
import com.rohan.model.EmployeeModel;
import com.rohan.model.EmployeeVO;

public interface EmployeeService {

	Integer addEmployees(EmployeeModel... employeeModels);
	EmployeeVO getEmployeeById(Integer id);
	List<EmployeeVO> getEmployeeByCityAndName(String city, String name);
	List<EmployeeVO> getEmployeeByCity(String city);
	List<EmployeeVO> getEmployeeByName(String name);
	List<EmployeeVO> getEmployeeByType(String type);
	List<EmployeeVO> getAllEmployees();
}