package com.example.sb.cruddemo.dao;

import com.example.sb.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members") //uncomment to test
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // No need to define any method
    // spring will provide default method through JpaRepository
    // just need to specify entity class and primary column type
}
