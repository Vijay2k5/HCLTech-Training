package com.hcltech.collections.app;

import com.hcltech.collections.model.Employee;
import com.hcltech.collections.service.EmployeeDirectory;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        directory.addEmployee(new Employee(
                "E103", "Arun", "Engineering",
                new BigDecimal("75000")));

        directory.addEmployee(new Employee(
                "E101", "Bala", "HR",
                new BigDecimal("50000")));

        directory.addEmployee(new Employee(
                "E105", "Divya", "Engineering",
                new BigDecimal("92000")));

        directory.addEmployee(new Employee(
                "E102", "Charan", "Finance",
                new BigDecimal("68000")));

        directory.addEmployee(new Employee(
                "E104", "Ezhil", "Engineering",
                new BigDecimal("92000")));

        directory.addEmployee(new Employee(
                "E106", "Farah", "Finance",
                new BigDecimal("61000")));

        System.out.println("=== Lookup ===");
        System.out.println(directory.findById("E103"));

        System.out.println("\n=== Natural Order: Employee ID ===");
        directory.getEmployeesSortedById()
                .forEach(System.out::println);

        System.out.println("\n=== Department Counts ===");
        System.out.println(directory.countByDepartment());

        System.out.println("\n=== Department Report ===");
        directory.departmentReport().forEach((department, employees) -> {
            System.out.println(department);

            employees.forEach(employee ->
                    System.out.println("  " + employee));
        });

        System.out.println("\n=== Top 5 Salaries ===");
        directory.getTopFiveBySalary()
                .forEach(System.out::println);

        System.out.println("\n=== Department, Then ID ===");
        directory.getSortedByDepartmentAndId()
                .forEach(System.out::println);

        System.out.println("\n=== Duplicate ID Check ===");
        boolean added = directory.addEmployee(new Employee(
                "E103", "Another Person", "HR",
                new BigDecimal("40000")));

        System.out.println("Duplicate employee added? " + added);
        System.out.println("Employee count: " + directory.size());
    }
}