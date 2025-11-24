package com.helloworld.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "EMPLOYEE_DETAILS", schema = "AISHU_USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @Column(name = "emp_id")
    private String empId;

    private String type;
    private String idNo;
    private String title;
    private String name;
    private String designation;
    private String directory;
    private String division;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfJoin;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfPost;

    private String qualification;
    private String discipline;
    private String gender;
    private String bloodGroup;
    private String phone;
    private String address;
    private String permanentAddress;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
}
