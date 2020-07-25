package com.wellnes.testcommunicate.repositories;

import com.wellnes.testcommunicate.models.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
