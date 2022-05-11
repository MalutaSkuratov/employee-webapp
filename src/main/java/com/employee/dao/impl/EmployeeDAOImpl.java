package com.employee.dao.impl;

import com.employee.dao.EmployeeDAO;
import com.employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> employees = session.createQuery("from Employee", Employee.class)
                .getResultList();
        return employees;
    }

    @Override
    public Employee getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void createOrUpdate(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> queryToEmployeeDelete = session.createQuery("delete from Employee where id=:employeeId");
        queryToEmployeeDelete.setParameter("employeeId", id);
        queryToEmployeeDelete.executeUpdate();
    }
}
