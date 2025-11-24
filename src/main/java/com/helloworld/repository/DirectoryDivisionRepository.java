package com.helloworld.repository;

import com.helloworld.model.DirectoryDivision;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DirectoryDivisionRepository extends JpaRepository<DirectoryDivision, Long> {

    List<DirectoryDivision> findByDirectoryName(String directoryName);

    // For dropdown values (unique)
    List<DirectoryDivision> findDistinctByDirectoryNameIsNotNull();
}
