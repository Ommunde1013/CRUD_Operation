package com.curd.repo;

import org.springframework.data.repository.CrudRepository;

import com.curd.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
