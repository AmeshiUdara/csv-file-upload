package com.ameshi.csvupload.csvupload.repository;

import com.ameshi.csvupload.csvupload.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRepository extends JpaRepository<Employee, Long> {
}
