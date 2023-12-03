package com.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.curd.dao.EmployeeDao;
import com.curd.entity.Employee;

@RestController
public class EmployeeController 
{
	private final EmployeeDao dao;

    @Autowired
    public EmployeeController(EmployeeDao dao) 
    {
        this.dao = dao;
    }

    @GetMapping("/")
    public List<Employee> getAll() 
    {
        return dao.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) 
    {
        return dao.getEmployeeById(id);
    }

    @PostMapping("/")
    public Employee addEmployee(@RequestBody Employee employee) 
    {
        return dao.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) 
    {
        return dao.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) 
    {
        dao.deleteEmployeeById(id);
    }
}
