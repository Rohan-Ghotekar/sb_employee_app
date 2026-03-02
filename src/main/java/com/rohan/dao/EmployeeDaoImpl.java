package com.rohan.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.rohan.Entity.EmployeeEntity;
import com.rohan.repository.EmployeeRepository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public Integer addEmployees(List<EmployeeEntity>employees) {
		return repository.saveAll(employees).size();
		
	}
	@Override
	public List<EmployeeEntity> getEmployeeByCityAndName(String name,String city) {
		List<EmployeeEntity>list =repository.findAllByEmpCityAndEmpName(city, name);
		return list;
		
	}
	@Override
	public Optional<EmployeeEntity> getEmployeeById(Integer empId) {
		return repository.findById(empId);
	}
	@Override
	public List<EmployeeEntity> getEmployeeByCity(String city) {
		return repository.findAllByEmpCity(city);
	}
	@Override
	public List<EmployeeEntity> getEmployeeByName(String name) {
		return repository.findAllByEmpName(name);
	}
	@Override
	public boolean employeeExistById(Integer id) {
		return repository.existsById(id);
	}
	@Override
	public List<EmployeeEntity> getEmployeeByType(String type) {
		return repository.findAllByEmpType(type);
	}
	@Override
	public List<EmployeeEntity> getAllEmployees() {
		return repository.findAll();
	}
	@Override
	public void deleteEmployeeById(Integer empId) {
		repository.deleteById(empId);
	}
	@Override
	public void updateEmployee(EmployeeEntity employee) {
		repository.save(employee);
	}
	
	
}
