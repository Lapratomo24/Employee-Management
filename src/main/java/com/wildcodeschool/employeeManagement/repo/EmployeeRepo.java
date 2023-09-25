package com.wildcodeschool.employeeManagement.repo;

import com.wildcodeschool.employeeManagement.model.Employee;
// for accessing database and implementing CRUD operations
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
