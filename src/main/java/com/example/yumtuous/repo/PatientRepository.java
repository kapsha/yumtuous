package com.example.yumtuous.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example.yumtuous.model.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    public List<Patient> findByFullName(String fullName); 
}