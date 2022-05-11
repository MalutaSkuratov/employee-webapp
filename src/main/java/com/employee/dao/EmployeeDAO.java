package com.employee.dao;

import com.employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAll();

    Employee getById(int id);

    void createOrUpdate(Employee employee);

    void delete(int id);
}
