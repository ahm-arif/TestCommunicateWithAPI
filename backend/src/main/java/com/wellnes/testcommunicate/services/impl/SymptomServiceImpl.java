package com.wellnes.testcommunicate.services.impl;

import com.wellnes.testcommunicate.exceptions.NotFoundException;
import com.wellnes.testcommunicate.models.entities.Symptom;
import com.wellnes.testcommunicate.repositories.SymptomRepository;
import com.wellnes.testcommunicate.services.api.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SymptomServiceImpl implements SymptomService {

  @Autowired
  private SymptomRepository repository;

  @Override
  public Symptom findById(int id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("Symptom not found"));
  }
}
