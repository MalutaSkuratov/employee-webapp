package com.employee.services.impl;

import com.employee.dao.EmployeeDAO;
import com.employee.entity.Employee;
import com.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    @Override
    @Transactional
    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }

    @Override
    @Transactional
    public void createOrUpdate(Employee employee) {
        employeeDAO.createOrUpdate(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDAO.delete(id);
    }
}
