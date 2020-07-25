package com.wellnes.testcommunicate.repositories;

import com.wellnes.testcommunicate.models.entities.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymptomRepository extends JpaRepository<Symptom, Integer> {
}
