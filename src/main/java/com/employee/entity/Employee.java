package com.employee.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Name must be not empty")
    @Size(max = 30, message = "Name cannot be greater than 30 symbols")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "Name must be empty")
    @Size(max = 30, message = "Surname cannot be greater than 30 symbols")
    private String surname;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    @Min(value = 500, message = "Salary cannot be less than 500$")
    @Max(value = 5500, message = "Salary cannot be greater than 5500$")
    private int salary;

    public Employee() {
    }

    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
