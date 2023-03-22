package com.addressBookApp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "api/v1/employees")
    public List<Employee> getEmployee () {
        return employeeService.getEmployee();
    }

    @PostMapping(path = "api/v1/employees/create")
    public void addNewEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping(path = "api/v1/employees/{employeeID}")
    public void deleteEmployee(@PathVariable("employeeID") Integer employeeId) {
        employeeService.deleteEmployee(employeeId);

    }
}
