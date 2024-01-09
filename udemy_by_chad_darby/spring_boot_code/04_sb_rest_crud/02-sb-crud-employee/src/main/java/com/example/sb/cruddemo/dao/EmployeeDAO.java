package com.example.sb.cruddemo.dao;

import com.example.sb.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);

    Employee save(Employee theEmp);


    void deleteById(int id);

}
