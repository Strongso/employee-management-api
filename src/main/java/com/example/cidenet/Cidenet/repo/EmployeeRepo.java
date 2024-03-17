package com.example.cidenet.Cidenet.repo;

import com.example.cidenet.Cidenet.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Boolean existsByEmail(String email);
    Boolean existsByIdNumber(String idNumber);
}