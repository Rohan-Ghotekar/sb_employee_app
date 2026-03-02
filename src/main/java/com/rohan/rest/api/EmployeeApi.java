package com.rohan.rest.api;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rohan.model.EmployeeModel;
import com.rohan.model.EmployeeVO;
import com.rohan.service.EmployeeService;

@RestController
@RequestMapping("emp")
public class EmployeeApi {
	@Autowired
	private EmployeeService employeeService;
	private static final Logger logger=LoggerFactory.getLogger(EmployeeApi.class);

	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeModel... employeeModel) {
		logger.info("\nIn addEmployee Method");
		System.out.println(employeeModel);
		Integer count=employeeService.addEmployees(employeeModel);
		return ResponseEntity.status(200).body(count+" Employee added Successfully");
	}
	
	@GetMapping("getbyid/{empId}")
	public ResponseEntity<EmployeeVO> getEmployeeById(@PathVariable Integer empId){
		logger.info("\nIn getEmployeeById Method");
		EmployeeVO emp=employeeService.getEmployeeById(empId);
		System.out.println(emp);
		return ResponseEntity.status(HttpStatus.OK).body(emp);
	}
	@GetMapping("getbycityandname")
	public ResponseEntity<List<EmployeeVO>> getEmployeeByNameAndCity(@RequestParam String city,@RequestParam String name){
		logger.info("\nIn getEmployeeByNameAndCity Method");
		List<EmployeeVO>empList=employeeService.getEmployeeByCityAndName(city, name);
		System.out.println("In API: "+empList);
		return ResponseEntity.status(HttpStatus.OK).body(empList);
	}
	
	@GetMapping("getbycity")
	public ResponseEntity<List<EmployeeVO>> getEmployeeByCity(@RequestParam String city){
		logger.info("\nIn getEmployeeByCity Method");
		List<EmployeeVO>empList=employeeService.getEmployeeByCity(city);
		return ResponseEntity.status(HttpStatus.OK).body(empList);
	}
	
	@GetMapping("getbyname")
	public ResponseEntity<List<EmployeeVO>> getEmployeeByName(@RequestParam String name){
		logger.info("\nIn getEmployeeByName Method");
		List<EmployeeVO>empList=employeeService.getEmployeeByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(empList);
	}
	@GetMapping("getbytype")
	public ResponseEntity<List<EmployeeVO>> getEmployeeByType(@RequestParam String type){
		logger.info("\nIn getEmployeeByType Method");
		List<EmployeeVO>empList=employeeService.getEmployeeByType(type);
		return ResponseEntity.status(HttpStatus.OK).body(empList);
	}
	@GetMapping("getallemployees")
	public ResponseEntity<List<EmployeeVO>> getAllEmployees(){
		logger.info("\nIn getAllEmployees Method");
		List<EmployeeVO>empList=employeeService.getAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(empList);
	}
}
