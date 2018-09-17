package com.example.yumtuous.repo;

import org.springframework.data.repository.CrudRepository;
import com.example.yumtuous.model.EmergencyContact;

public interface EmergencyContactRepository extends CrudRepository<EmergencyContact, Long> {
}
