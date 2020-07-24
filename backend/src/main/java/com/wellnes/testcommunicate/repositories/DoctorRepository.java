package com.wellnes.testcommunicate.repositories;

import com.wellnes.testcommunicate.models.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
  Page<Doctor> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
