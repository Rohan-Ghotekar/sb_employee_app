package com.rohan.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public record EmployeeVO (Integer empId,String empName,String empCity,String empType){
	
}
