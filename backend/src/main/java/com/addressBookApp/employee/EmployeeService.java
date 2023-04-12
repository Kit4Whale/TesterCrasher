package com.addressBookApp.employee;

import com.addressBookApp.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,
                           ClientRepository clientRepository) {
        this.employeeRepository = employeeRepository;
        this.clientRepository = clientRepository;
    }

    public Page<Employee> getEmployee (Integer limit) {
        return employeeRepository.findAll(PageRequest.ofSize(limit));
    }

    public void addEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.
                findEmployeeByLogin(employee.getLogin());
        if(employeeOptional.isPresent()) {
            throw new IllegalStateException("login taken");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if(!exists) {
            throw new IllegalStateException("employee with id " + employeeId + " dose not exists");
        }
        employeeRepository.deleteById(employeeId);
    }

    @Transactional
    public void updateEmployee(Integer employeeId,
                               Employee employee) {
        Employee employeeRep = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException(
                        "employee with id " + employeeId + " dose not exists"));

        if(employee.getName() != null &&
                employee.getName().length() > 0 &&
                !Objects.equals(employeeRep.getName(), employee.getName())) {
            employeeRep.setName(employee.getName());
        }

        if(employee.getLogin() != null &&
        employee.getLogin().length() > 0 &&
        !Objects.equals(employeeRep.getLogin(), employee.getLogin())) {
            employeeRep.setLogin(employee.getLogin());
        }
    }
}
