
package com.hcltech.collections.service;

import com.hcltech.collections.model.Employee;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDirectory {

    private final Map<String, Employee> employees = new HashMap<>();

    public boolean addEmployee(Employee employee) {
        Objects.requireNonNull(employee, "employee cannot be null");

        if (employees.containsKey(employee.getId())) {
            return false;
        }

        employees.put(employee.getId(), employee);
        return true;
    }

    public Employee findById(String id) {
        return employees.get(id);
    }

    public List<Employee> getEmployeesSortedById() {
        List<Employee> result = new ArrayList<>(employees.values());
        Collections.sort(result); // Uses Comparable
        return result;
    }

    public Map<String, Integer> countByDepartment() {
        Map<String, Integer> counts = new HashMap<>();

        for (Employee employee : employees.values()) {
            counts.merge(
                    employee.getDepartment(),
                    1,
                    Integer::sum
            );
        }

        return counts;
    }

    public Map<String, List<Employee>> departmentReport() {
        Map<String, List<Employee>> report = new TreeMap<>();

        for (Employee employee : employees.values()) {
            report.computeIfAbsent(
                    employee.getDepartment(),
                    key -> new ArrayList<>()
            ).add(employee);
        }

        return report;
    }

    // Comparator 1: salary descending, then name ascending
    public List<Employee> getTopFiveBySalary() {
        Comparator<Employee> salaryOrder =
                Comparator.comparing(Employee::getSalary)
                          .reversed()
                          .thenComparing(Employee::getName)
                          .thenComparing(Employee::getId);

        return employees.values()
                .stream()
                .sorted(salaryOrder)
                .limit(5)
                .collect(Collectors.toList());
    }

    // Comparator 2: department ascending, then ID ascending
    public List<Employee> getSortedByDepartmentAndId() {
        Comparator<Employee> departmentOrder =
                Comparator.comparing(Employee::getDepartment)
                          .thenComparing(Employee::getId);

        return employees.values()
                .stream()
                .sorted(departmentOrder)
                .collect(Collectors.toList());
    }

    // Demonstrates LinkedHashMap preserving insertion order
    public Map<String, Employee> getInsertionOrderView() {
        Map<String, Employee> ordered = new LinkedHashMap<>();

        for (Employee employee : employees.values()) {
            ordered.put(employee.getId(), employee);
        }

        return ordered;
    }

    public int size() {
        return employees.size();
    }
}
