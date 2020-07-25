package com.wellnes.testcommunicate.services.api;

import com.wellnes.testcommunicate.models.entities.Symptom;

public interface SymptomService {
  Symptom findById(int id);
}
