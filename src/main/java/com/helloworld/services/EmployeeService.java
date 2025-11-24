package com.helloworld.services;

import com.helloworld.model.Employee;
import java.util.List;

public interface EmployeeService {
    
    List<Employee> getAllEmployees();
    List<String> getDivisionsByDirectory(String directory);
    List<String> getAllDirectories();
    
    Employee addEmployee(Employee employee);
    
    Employee updateEmployee(String id, Employee employee);
    
    void deleteEmployee(String id);
}
