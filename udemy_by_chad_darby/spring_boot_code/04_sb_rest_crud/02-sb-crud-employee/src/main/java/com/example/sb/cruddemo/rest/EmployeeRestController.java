package com.example.sb.cruddemo.rest;

import com.example.sb.cruddemo.dao.EmployeeDAO;
import com.example.sb.cruddemo.entity.Employee;
import com.example.sb.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeByID(@PathVariable int id) {

        Employee emp = employeeService.findById(id);
        if (emp == null) {
            throw new RuntimeException("Employee not found-" + id);
        }
        return emp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp) {
        emp.setId(0); // if mistakenly pass id
        return employeeService.save(emp);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp) {
        return employeeService.save(emp);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeByID(@PathVariable int id) {
        employeeService.deleteById(id);
    }
}
