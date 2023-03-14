package com.addressBookApp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployee () {
        return employeeService.getEmployee();
    }

    @PostMapping
    public void addNewEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }
}
