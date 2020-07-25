package com.wellnes.testcommunicate.repositories;

import com.wellnes.testcommunicate.models.entities.DoctorCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorCategoryRepository extends JpaRepository<DoctorCategory, Integer> {
}
