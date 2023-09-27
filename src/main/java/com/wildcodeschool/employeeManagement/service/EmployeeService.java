package com.wildcodeschool.employeeManagement.service;

import com.wildcodeschool.employeeManagement.exception.UserNotFoundException;
import com.wildcodeschool.employeeManagement.model.Employee;
import com.wildcodeschool.employeeManagement.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User not found."));
    }

    public void deleteEmployee(Long id) {
        Optional<Employee> deleteEmployee = employeeRepo.findById(id);
        if (deleteEmployee.isPresent()) {
            Employee exist = deleteEmployee.get();
            employeeRepo.deleteById(exist.getId());
        }
        employeeRepo.deleteEmployeeById(id);
    }
}
