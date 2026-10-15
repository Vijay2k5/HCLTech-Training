package com.hcltech.collections.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee implements Comparable<Employee> {

    private final String id;
    private final String name;
    private final String department;
    private final BigDecimal salary;

    public Employee(
            String id,
            String name,
            String department,
            BigDecimal salary
    ) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.name = Objects.requireNonNull(name, "name cannot be null");
        this.department = Objects.requireNonNull(
                department, "department cannot be null");
        this.salary = Objects.requireNonNull(
                salary, "salary cannot be null");

        if (salary.signum() < 0) {
            throw new IllegalArgumentException(
                    "Salary cannot be negative");
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    // Natural ordering: employee ID
    @Override
    public int compareTo(Employee other) {
        return this.id.compareTo(other.id);
    }

    // Employee identity is defined by ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Employee other)) {
            return false;
        }

        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{id='%s', name='%s', department='%s', salary=%s}"
                .formatted(id, name, department, salary);
    }
}