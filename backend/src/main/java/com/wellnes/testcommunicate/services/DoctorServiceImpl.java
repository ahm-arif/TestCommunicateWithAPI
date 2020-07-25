package com.wellnes.testcommunicate.services;

import com.wellnes.testcommunicate.models.entities.Doctor;
import com.wellnes.testcommunicate.models.inbounds.DoctorInbound;
import com.wellnes.testcommunicate.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

  @Autowired
  private DoctorRepository doctorRepository;

  @Override
  public Page<Doctor> searchDoctorByName(String name, int page, int limit) {
    if (name.equals("")) {
      return doctorRepository.findAll(PageRequest.of(page, limit));
    }
    return doctorRepository.findAllByNameContainingIgnoreCase(name, PageRequest.of(page, limit));
  }

  @Override
  public Doctor createDoctor(DoctorInbound doctorInbound) {
    Doctor doctor = Doctor.builder()
            .name(doctorInbound.getName())
            .title(doctorInbound.getSpecialization())
            .build();

    return doctorRepository.save(doctor);
  }

  @Override
  public void deleteDoctor(int id) {
    doctorRepository.deleteById(id);
  }

  @Override
  public Doctor updateDoctor(int id, DoctorInbound doctorInbound) {
    Doctor doctor = Optional.of(id)
            .flatMap(doctorRepository::findById)
            .orElse(Doctor.builder().build());
    String name = Optional.of(doctorInbound.getName())
            .orElse(doctor.getName());
    String specialization = Optional.ofNullable(doctorInbound.getSpecialization())
            .orElse(doctor.getTitle());
    doctor.setName(name);
    doctor.setTitle(specialization);
    return doctorRepository.save(doctor);
  }
}
