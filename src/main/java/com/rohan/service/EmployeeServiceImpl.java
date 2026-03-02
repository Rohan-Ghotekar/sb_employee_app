package com.rohan.service;

import java.util.Arrays;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rohan.Entity.EmployeeEntity;
import com.rohan.dao.EmployeeDao;
import com.rohan.exception.EmployeeNotAddedException;
import com.rohan.exception.EmployeeNotFoundException;
import com.rohan.model.EmployeeModel;
import com.rohan.model.EmployeeVO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private ModelMapper modelMapper;


	@Override
	public Integer addEmployees(EmployeeModel... employeeModels) {
//		System.out.println(employeeModels);
		
		List<EmployeeEntity> list=Arrays.stream(employeeModels)
				.map(model->modelMapper.map(model,EmployeeEntity.class))
				.toList();
		System.out.println("In service: "+list);
		
		List<EmployeeEntity> toAdd = list.stream()
	            .filter(e -> !employeeDao.employeeExistById(e.getEmpId()))
	            .toList();

	    if(toAdd.isEmpty()) {
	        throw new EmployeeNotAddedException("No employees were added. All employees already exist.");
	    }

	    Integer count = employeeDao.addEmployees(toAdd);
	    return count;
	}
	
	@Override
	public EmployeeVO getEmployeeById(Integer id) {
		EmployeeEntity emp= employeeDao.getEmployeeById(id)
				.orElseThrow(()->
					new EmployeeNotFoundException("Employee not found with id: " + id));
		EmployeeModel model= modelMapper.map(emp,EmployeeModel.class);
		return new EmployeeVO(model.getEmpId(),model.getEmpName(),model.getEmpCity(),model.getEmpType());
	}
	
	@Override
	public List<EmployeeVO>getEmployeeByCityAndName(String city,String name){
		List<EmployeeEntity>list =employeeDao.getEmployeeByCityAndName(name, city);
		if(list.isEmpty()) {
			throw(new EmployeeNotFoundException("Employee not found with name: " + name+" and City: "+city));
		}
		List<EmployeeModel> models = list.stream()
		        .map(entity -> modelMapper.map(entity, EmployeeModel.class))
		        .toList();
		
		return models.stream()
		        .map(model -> new EmployeeVO(model.getEmpId(), model.getEmpName(), model.getEmpCity(),model.getEmpType()))
		        .toList();
	}

	@Override
	public List<EmployeeVO> getEmployeeByCity(String city) {
		List<EmployeeEntity>list =employeeDao.getEmployeeByCity(city);
		if(list.isEmpty()) {
			throw(new EmployeeNotFoundException("Employee not found with City: "+city));
		}
		List<EmployeeModel> models = list.stream()
		        .map(entity -> modelMapper.map(entity, EmployeeModel.class))
		        .toList();
		
		return models.stream()
		        .map(model -> new EmployeeVO(model.getEmpId(), model.getEmpName(), model.getEmpCity(),model.getEmpType()))
		        .toList();
	}

	@Override
	public List<EmployeeVO> getEmployeeByName(String name) {
		List<EmployeeEntity>list =employeeDao.getEmployeeByName(name);
		if(list.isEmpty()) {
			throw(new EmployeeNotFoundException("Employee not found with name: " + name));
		}
		List<EmployeeModel> models = list.stream()
		        .map(entity -> modelMapper.map(entity, EmployeeModel.class))
		        .toList();
		
		return models.stream()
		        .map(model -> new EmployeeVO(model.getEmpId(), model.getEmpName(), model.getEmpCity(),model.getEmpType()))
		        .toList();
	}

	@Override
	public List<EmployeeVO> getEmployeeByType(String type) {
		List<EmployeeEntity>list =employeeDao.getEmployeeByType(type);
		if(list.isEmpty()) {
			throw(new EmployeeNotFoundException("Employee not found with type: " + type));
		}
		List<EmployeeModel> models = list.stream()
		        .map(entity -> modelMapper.map(entity, EmployeeModel.class))
		        .toList();
		
		return models.stream()
		        .map(model -> new EmployeeVO(model.getEmpId(), model.getEmpName(), model.getEmpCity(),model.getEmpType()))
		        .toList();
	}

	@Override
	public List<EmployeeVO> getAllEmployees() {
		List<EmployeeEntity>list =employeeDao.getAllEmployees();
		if(list.isEmpty()) {
			throw(new EmployeeNotFoundException("Employee Data Not Available!!"));
		}
		List<EmployeeModel> models = list.stream()
		        .map(entity -> modelMapper.map(entity, EmployeeModel.class))
		        .toList();
		
		return models.stream()
		        .map(model -> new EmployeeVO(model.getEmpId(), model.getEmpName(), model.getEmpCity(),model.getEmpType()))
		        .toList();
	}
}
