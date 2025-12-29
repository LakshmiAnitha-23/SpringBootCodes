package com.example.EmployeeCRUD.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "EMPLOYEE")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String empName;
    private String department;
    private double salary;

    public Employee()
    {
    }

    public Employee(String empName, String department,double salary)
    {
        this.empName = empName;
        this.department = department;
        this.salary = salary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
