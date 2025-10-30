package com.helloworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.helloworld.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    // JpaRepository provides all basic CRUD methods — no extra code needed
}