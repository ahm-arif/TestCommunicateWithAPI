package com.wellnes.testcommunicate.services.impl;

import com.wellnes.testcommunicate.exceptions.NotFoundException;
import com.wellnes.testcommunicate.models.entities.DoctorCategory;
import com.wellnes.testcommunicate.repositories.DoctorCategoryRepository;
import com.wellnes.testcommunicate.services.api.DoctorCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorCategoryServiceImpl implements DoctorCategoryService {

  @Autowired
  private DoctorCategoryRepository repository;

  @Override
  public DoctorCategory findOne(int id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("Doctor category not found"));
  }

}
