package com.example.sb.cruddemo.service;

import com.example.sb.cruddemo.dao.EmployeeDAO;
import com.example.sb.cruddemo.dao.EmployeeDaoJpaImpl;
import com.example.sb.cruddemo.dao.EmployeeRepository;
import com.example.sb.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee emp = null;
        if (result.isPresent()) {
            emp = result.get();
        } else {
            throw new RuntimeException("Employee invalid id" + id);
        }
        return emp;
    }

    @Override
    public Employee save(Employee theEmp) {
        return employeeRepository.save(theEmp);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
