package com.addressBookApp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "api/v1/employees")
    public Page<Employee> getEmployee (
            @RequestParam("limit") Integer limit) {
        return employeeService.getEmployee(limit);
    }

    @PostMapping(path = "api/v1/employees/create")
    public void addNewEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping(path = "api/v1/employees/{employeeID}")
    public void deleteEmployee(@PathVariable("employeeID") Integer employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @PostMapping(path = "api/v1/employees/update/{employeeID}")
    public void updateEmployee(
            @PathVariable("employeeID") Integer employeeId,
            @RequestBody Employee employee) {
        employeeService.updateEmployee(employeeId, employee);

    }
}
