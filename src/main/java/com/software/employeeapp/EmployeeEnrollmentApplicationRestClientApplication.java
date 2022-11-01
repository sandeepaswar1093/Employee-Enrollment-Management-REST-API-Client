package com.software.employeeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.software.employeeapp.controllers.RestClient;

@SpringBootApplication
public class EmployeeEnrollmentApplicationRestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeEnrollmentApplicationRestClientApplication.class, args);
		
		RestClient.callGetAllEmployeesAPI();
		//RestClient.callCreateEmployeesAPI();
		//RestClient.callUpdateEmployeeAPI();
		//RestClient.callDeleteAPI();
	}

}
