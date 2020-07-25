package com.wellnes.testcommunicate.services.impl;

import com.wellnes.testcommunicate.exceptions.NotFoundException;
import com.wellnes.testcommunicate.models.entities.AppointmentType;
import com.wellnes.testcommunicate.repositories.AppointmentTypeRepository;
import com.wellnes.testcommunicate.services.api.AppointmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentTypeServiceImpl implements AppointmentTypeService {

  @Autowired
  private AppointmentTypeRepository repository;

  @Override
  public AppointmentType findById(int id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("Appointment type not found"));
  }
}
