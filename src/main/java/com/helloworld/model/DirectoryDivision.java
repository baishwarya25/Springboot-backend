package com.helloworld.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "DIRECTORY_DIVISION", schema = "AISHU_USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DirectoryDivision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DIRECTORY_NAME")
    private String directoryName;

    @Column(name = "DIVISION_NAME")
    private String divisionName;
}

