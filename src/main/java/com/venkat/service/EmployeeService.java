package com.venkat.service;

import com.venkat.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public Employee addEmployee(Employee employee) {
        employee.setId(counter.incrementAndGet());
        employees.add(employee);
        return employee;
    }

    public List<Employee> findAllEmployees() { return employees; }

    public Employee findEmployeeById(long id) {
        return employees
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Employee updateEmployee(long id, Employee employee) {
        Employee emp = findEmployeeById(id);
        if (emp == null) {
            return null;
        }
        employee.setId(id);
        employees.removeIf(e -> e.getId() == employee.getId());
        employees.add(employee);
        return employee;
    }

    public void deleteEmployee(long id) {
        employees.removeIf(e -> e.getId() == id);
    }

}
