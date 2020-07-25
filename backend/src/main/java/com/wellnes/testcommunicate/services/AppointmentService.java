package com.wellnes.testcommunicate.services;

import com.wellnes.testcommunicate.models.entities.Appointment;
import com.wellnes.testcommunicate.models.inbounds.ComplaintInbound;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ComplaintService {

  Page<Appointment> findAll(int page, int limit);
  Optional<Appointment> findOne(int id);
  void delete(int id);
  Appointment create(ComplaintInbound complaint);
  Appointment update(int id, ComplaintInbound complaint);

}
