package com.wellnes.testcommunicate.repositories;

import com.wellnes.testcommunicate.models.entities.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

}
