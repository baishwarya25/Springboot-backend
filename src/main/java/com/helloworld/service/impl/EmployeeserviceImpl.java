package com.helloworld.service.impl;

import com.helloworld.model.Employee;
import com.helloworld.model.DirectoryDivision;
import com.helloworld.repository.EmployeeRepository;
import com.helloworld.repository.DirectoryDivisionRepository;
import com.helloworld.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeserviceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private DirectoryDivisionRepository directoryRepo;

    @Override
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {
        employee.setEmpId(id);
        return repository.save(employee);
    }

    @Override
    public void deleteEmployee(String id) {
        repository.deleteById(id);
    }

    // 🔥 NEW METHODS FOR DIRECTORY & DIVISION DROPDOWNS

    @Override
    public List<String> getAllDirectories() {
        return directoryRepo.findDistinctByDirectoryNameIsNotNull()
                .stream()
                .map(DirectoryDivision::getDirectoryName)
                .distinct()
                .toList();
    }

    @Override
    public List<String> getDivisionsByDirectory(String directory) {
        return directoryRepo.findByDirectoryName(directory)
                .stream()
                .map(DirectoryDivision::getDivisionName)
                .distinct()
                .toList();
    }
}
