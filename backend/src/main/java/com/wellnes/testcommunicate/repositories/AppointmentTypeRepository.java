package com.wellnes.testcommunicate.repositories;

import com.wellnes.testcommunicate.models.entities.AppointmentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentTypeRepository extends JpaRepository<AppointmentType, Integer> {
}
