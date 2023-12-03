package com.curd.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.entity.Employee;
import com.curd.repo.EmployeeRepo;

@Service
public class EmployeeDao {

    @Autowired
    private EmployeeRepo repo;

    public List<Employee> getAllEmployee() 
    {
        try 
        {
            return (List<Employee>) repo.findAll();
        } 
        catch (Exception e) 
        {
            // Log or throw a custom exception
            System.out.println("Error while fetching all employees: " + e.getMessage());
            throw new RuntimeException("Error while fetching all employees", e);
        }
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> emp = repo.findById(id);
        return emp.orElse(null); // Returns null if employee is not found with given id
    }

    public Employee addEmployee(Employee emp) {
        try {
            return repo.save(emp);
        } catch (Exception e) {
            System.out.println("Error while adding employee: " + e.getMessage());
            throw new RuntimeException("Error while adding employee", e);
        }
    }

    public Employee updateEmployee(int id, Employee emp) {
        Employee existingEmployee = getEmployeeById(id);

        if (existingEmployee != null) {
            existingEmployee.setEmpName(emp.getEmpName());
            existingEmployee.setEmpEmail(emp.getEmpEmail());
            existingEmployee.setEmpPosition(emp.getEmpPosition());
            existingEmployee.setEmpSalary(emp.getEmpSalary());

            return repo.save(existingEmployee);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    public Employee deleteEmployeeById(int id) {
        Employee emp = getEmployeeById(id);

        if (emp != null) {
            repo.deleteById(id);
            return emp;
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }
}
