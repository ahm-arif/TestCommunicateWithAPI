package com.wellnes.testcommunicate.services;

import com.wellnes.testcommunicate.models.entities.Doctor;
import com.wellnes.testcommunicate.models.inbounds.DoctorInbound;
import org.springframework.data.domain.Page;

public interface DoctorService {
  Page<Doctor> searchDoctorByName(String name, int page, int limit);
  Doctor createDoctor(DoctorInbound doctorInbound);
  void deleteDoctor(int id);
  Doctor updateDoctor(int id, DoctorInbound doctorInbound);
}
