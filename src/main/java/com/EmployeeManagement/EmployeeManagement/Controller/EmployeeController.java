package com.EmployeeManagement.EmployeeManagement.Controller;


import com.EmployeeManagement.EmployeeManagement.Exception.ResourceNotFoundException;
import com.EmployeeManagement.EmployeeManagement.Model.Employee;
import com.EmployeeManagement.EmployeeManagement.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController

@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    private List<Employee> getAllEmployees(){

    return employeeRepository.findAll();

    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long Id)
    {
        System.out.println(Id);
        Optional<Employee> employee = employeeRepository.findById(Id);


        if(!employee.isPresent())
            throw new ResourceNotFoundException("Employee Not Found!");

        return employee.get();

    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") Long Id, @RequestBody Employee details){
        Optional<Employee> employee = employeeRepository.findById(Id);

        Employee e;
        if(!employee.isPresent())
            throw  new ResourceNotFoundException("Employee Not Found!");

        e=employee.get();
        if(Objects.nonNull(details.getFirstName())) {
            e.setFirstName(details.getFirstName());
        }
        if(Objects.nonNull(details.getLastName())) {
            e.setLastName(details.getLastName());
        }
        if(Objects.nonNull(details.getEmailId())) {
            e.setEmailId(details.getEmailId());
        }


        employeeRepository.save(e);
        return e;
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Long Id){

        Optional<Employee> employee = employeeRepository.findById(Id);

        if(!employee.isPresent())
            throw new ResourceNotFoundException("Employee Not Found!");


        employeeRepository.deleteById(Id);

        return new ResponseEntity<HttpStatus>(HttpStatus.GONE);



    }
}
