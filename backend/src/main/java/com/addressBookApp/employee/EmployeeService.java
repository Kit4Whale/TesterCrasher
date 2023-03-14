package com.addressBookApp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployee () {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.
                findEmployeeByLogin(employee.getLogin());
        if(employeeOptional.isPresent()) {
            throw new IllegalStateException("login taken");
        }
        employeeRepository.save(employee);
    }
}
