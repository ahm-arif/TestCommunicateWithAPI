package com.wellnes.testcommunicate.services;

import com.wellnes.testcommunicate.models.entities.Doctor;
import org.springframework.data.domain.Page;

public interface DoctorService {
  Page<Doctor> searchDoctorByName(String name, int page, int limit);
}
