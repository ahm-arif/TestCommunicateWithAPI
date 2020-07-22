package com.wellnes.testcommunicate.services;

import com.wellnes.testcommunicate.models.entities.Complaint;
import com.wellnes.testcommunicate.models.inbounds.ComplaintInbound;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ComplaintService {

  Page<Complaint> findAll(int page, int limit);
  Optional<Complaint> findOne(int id);
  void delete(int id);
  Complaint create(ComplaintInbound complaint);
  Complaint update(int id, ComplaintInbound complaint);

}
