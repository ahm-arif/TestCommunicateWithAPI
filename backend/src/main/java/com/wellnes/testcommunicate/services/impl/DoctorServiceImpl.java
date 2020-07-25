package com.wellnes.testcommunicate.services.impl;

import com.wellnes.testcommunicate.exceptions.NotFoundException;
import com.wellnes.testcommunicate.models.entities.Doctor;
import com.wellnes.testcommunicate.models.entities.DoctorCategory;
import com.wellnes.testcommunicate.models.inbounds.DoctorInbound;
import com.wellnes.testcommunicate.repositories.DoctorRepository;
import com.wellnes.testcommunicate.services.api.DoctorCategoryService;
import com.wellnes.testcommunicate.services.api.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

  @Autowired
  private DoctorRepository doctorRepository;

  @Autowired
  private DoctorCategoryService doctorCategoryService;

  @Override
  public Page<Doctor> searchDoctorByName(String name, int page, int limit) {
    if (name.equals("")) {
      return doctorRepository.findAll(PageRequest.of(page, limit));
    }
    return doctorRepository.findAllByNameContainingIgnoreCase(name, PageRequest.of(page, limit));
  }

  @Override
  public Doctor findById(int id) {
    return doctorRepository.findById(id).orElseThrow(() -> new NotFoundException("Doctor not found"));
  }

  @Override
  public Doctor createDoctor(DoctorInbound doctorInbound) {
    Doctor doctor = Doctor.builder()
            .name(doctorInbound.getName())
            .title(doctorInbound.getTitle())
            .address(doctorInbound.getAddress())
            .DOB(doctorInbound.getDOB())
            .gender(doctorInbound.getGender())
            .phone(doctorInbound.getPhone())
            .doctorCategories(
                    doctorInbound.getDoctorCategories()
                            .stream()
                            .map(doctorCategoryService::findOne)
                            .collect(Collectors.toList()))
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
    String name = Optional.ofNullable(doctorInbound.getName())
            .orElse(doctor.getName());
    String title = Optional.ofNullable(doctorInbound.getTitle())
            .orElse(doctor.getTitle());
    String address = Optional.ofNullable(doctorInbound.getAddress())
            .orElse(doctor.getAddress());
    String DOB = Optional.ofNullable(doctorInbound.getDOB())
            .orElse(doctor.getDOB());
    String gender = Optional.ofNullable(doctorInbound.getGender())
            .orElse(doctor.getGender());
    String phone = Optional.ofNullable(doctorInbound.getPhone())
            .orElse(doctor.getPhone());
    List<DoctorCategory> categories = Optional.ofNullable(doctorInbound.getDoctorCategories())
            .map(c -> c.stream().map(doctorCategoryService::findOne).collect(Collectors.toList()))
            .orElse(doctor.getDoctorCategories());

    doctor.setName(name);
    doctor.setTitle(title);
    doctor.setAddress(address);
    doctor.setDOB(DOB);
    doctor.setGender(gender);
    doctor.setPhone(phone);
    doctor.setDoctorCategories(categories);
    return doctorRepository.save(doctor);
  }
}
