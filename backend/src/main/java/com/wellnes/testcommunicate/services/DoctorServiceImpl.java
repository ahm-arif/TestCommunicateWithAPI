package com.wellnes.testcommunicate.services;

import com.wellnes.testcommunicate.models.entities.Doctor;
import com.wellnes.testcommunicate.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
}
