package com.employee.services;

import com.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee getById(int id);

    void createOrUpdate(Employee employee);

    void delete(int id);
}
