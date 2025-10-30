package com.helloworld.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

@Entity
@Table(name = "EMPLOYEE_DETAILS", schema = "AISHU_USER")
public class Employee {

    @Id
    @Column(name = "emp_id")
    private String empId;

    @Column(name = "type")
    private String type;

    @Column(name = "id_no")
    private String idNo;

    @Column(name = "title")
    private String title;

    @Column(name = "name")
    private String name;

    @Column(name = "designation")
    private String designation;

    @Column(name = "directory")
    private String directory;

    @Column(name = "division")
    private String division;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "date_of_join")
    private LocalDate dateOfJoin;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "date_of_post")
    private LocalDate dateOfPost;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "discipline")
    private String discipline;

    @Column(name = "sex")
    private String sex;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "permanent_address")
    private String permanentAddress;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "dob")
    private LocalDate dob;

    // Getters and Setters
    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getIdNo() { return idNo; }
    public void setIdNo(String idNo) { this.idNo = idNo; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getDirectory() { return directory; }
    public void setDirectory(String directory) { this.directory = directory; }

    public String getDivision() { return division; }
    public void setDivision(String division) { this.division = division; }

    public LocalDate getDateOfJoin() { return dateOfJoin; }
    public void setDateOfJoin(LocalDate dateOfJoin) { this.dateOfJoin = dateOfJoin; }

    public LocalDate getDateOfPost() { return dateOfPost; }
    public void setDateOfPost(LocalDate dateOfPost) { this.dateOfPost = dateOfPost; }

    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }

    public String getDiscipline() { return discipline; }
    public void setDiscipline(String discipline) { this.discipline = discipline; }

    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPermanentAddress() { return permanentAddress; }
    public void setPermanentAddress(String permanentAddress) { this.permanentAddress = permanentAddress; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }
}
