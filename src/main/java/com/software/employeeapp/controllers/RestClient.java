package com.software.employeeapp.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.software.employeeapp.entities.Employee;

public class RestClient {
	
	private static final String CREATE_EMPLOYEES_API = "http://localhost:9095/api/employees/add/";
	private static final String UPDATE_EMPLOYEES_API = "http://localhost:9095/api/employees/modify/{empId}";
	private static final String DELETE_EMPLOYEES_API = "http://localhost:9095/api/employees/delete/{empId}";
	private static final String GET_ALL_EMPLOYEES_API = "http://localhost:9095/api/employees/getAll/";
	
	static RestTemplate restTemplate = new RestTemplate();
	
	public static void callGetAllEmployeesAPI()
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_EMPLOYEES_API, HttpMethod.GET, entity, String.class);
		System.out.println(result);
	}
	
	public static void callCreateEmployeesAPI()
	{
		Employee emp  = new Employee(10,"Akash","Jadhav","akash1.jadhav@gmail.com");
		ResponseEntity<Employee> createdEmployee = restTemplate.postForEntity(CREATE_EMPLOYEES_API, emp, Employee.class);
		System.out.println(createdEmployee);
		
	}
	
	public static void callUpdateEmployeeAPI()
	{
		Map<String, Integer> param = new HashMap<>();
		param.put("empId", 1);
		Employee updateEmp  = new Employee(10,"Ankit","Wagh","ankit1.wagh@gmail.com");
		restTemplate.put(UPDATE_EMPLOYEES_API, updateEmp, param);
		
	}
	
	public static void callDeleteAPI()
	{
		Map<String, Integer> param = new HashMap<>();
		param.put("empId", 4);
		restTemplate.delete(DELETE_EMPLOYEES_API,param);
		
	}
	
	

}
