package com.helloworld.controller;

import com.helloworld.model.Employee;
import com.helloworld.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor   // ✨ Lombok constructor
@Slf4j   // Optional for logging
public class EmployeeController {

    private final EmployeeService service; // Lombok generates constructor automatically

    @GetMapping
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees...");
        return service.getAllEmployees();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        log.info("Adding employee: {}", employee.getName());
        return service.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        log.info("Updating employee with ID: {}", id);
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        log.warn("Deleting employee with ID: {}", id);
        service.deleteEmployee(id);
    }

    @GetMapping("/directories")
    public List<String> getDirectories() {
        return service.getAllDirectories();
    }

    @GetMapping("/divisions/{directory}")
    public List<String> getDivisions(@PathVariable String directory) {
        return service.getDivisionsByDirectory(directory);
    }
}
