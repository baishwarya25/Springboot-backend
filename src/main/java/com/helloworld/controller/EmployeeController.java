package com.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.helloworld.model.Employee;
import com.helloworld.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import java.util.*;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repo;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee emp) {
        if (repo.existsById(emp.getEmpId())) {
            return ResponseEntity.status(400).body(Map.of("message", "Employee ID already exists!"));
        }
        repo.save(emp);
        return ResponseEntity.ok(Map.of("message", "Employee added successfully!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id, @RequestBody Employee emp) {
        if (!repo.existsById(id)) {
            return ResponseEntity.status(404).body(Map.of("message", "Employee not found!"));
        }
        emp.setEmpId(id);
        repo.save(emp);
        return ResponseEntity.ok(Map.of("message", "Employee updated successfully!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.status(404).body(Map.of("message", "Employee not found!"));
        }
        repo.deleteById(id);
        return ResponseEntity.ok(Map.of("message", "Employee deleted successfully!"));
    }
}
