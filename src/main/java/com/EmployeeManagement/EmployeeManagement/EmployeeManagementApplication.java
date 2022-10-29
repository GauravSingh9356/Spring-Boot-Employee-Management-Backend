package com.EmployeeManagement.EmployeeManagement;

import com.EmployeeManagement.EmployeeManagement.Model.Employee;
import com.EmployeeManagement.EmployeeManagement.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception {
//		Employee employee = new Employee();
//		employee.setFirstName("Gaurav");
//		employee.setLastName("Singh");
//		employee.setEmailId("gs935688@gmail.com");
//
//		employeeRepository.save(employee);
//
//
//		Employee employee1 = new Employee();
//		employee1.setFirstName("John");
//		employee1.setLastName("Cena");
//		employee1.setEmailId("gs935688@gmail.com");
//
//		employeeRepository.save(employee1);
	}
}
