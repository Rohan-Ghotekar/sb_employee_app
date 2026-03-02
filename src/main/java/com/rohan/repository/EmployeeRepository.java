package com.rohan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohan.Entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
	List<EmployeeEntity> findAllByEmpCityAndEmpName(String city,String name);
	List<EmployeeEntity> findAllByEmpCity(String city);
	List<EmployeeEntity> findAllByEmpName(String name);
	List<EmployeeEntity> findAllByEmpType(String type);
}
