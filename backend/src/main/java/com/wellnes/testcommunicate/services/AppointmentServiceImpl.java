package com.wellnes.testcommunicate.services;

import com.wellnes.testcommunicate.models.entities.Appointment;
import com.wellnes.testcommunicate.models.inbounds.ComplaintInbound;
import com.wellnes.testcommunicate.repositories.AppointmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComplaintServiceImpl implements ComplaintService {

  private final AppointmentRepository appointmentRepository;

  public ComplaintServiceImpl(AppointmentRepository appointmentRepository) {
    this.appointmentRepository = appointmentRepository;
  }

  @Override
  public Page<Appointment> findAll(int page, int limit) {
    return appointmentRepository.findAll(PageRequest.of(page, limit));
  }

  @Override
  public Optional<Appointment> findOne(int id) {
    return appointmentRepository.findById(id);
  }

  @Override
  public void delete(int id) {
    appointmentRepository.deleteById(id);
  }

  @Override
  public Appointment create(ComplaintInbound complaint) {
    return appointmentRepository.save(Appointment.builder()
            .description(complaint.getDescription())
            .name(complaint.getName())
            .build());
  }

  @Override
  public Appointment update(int id, ComplaintInbound complaint) {
    Appointment existingAppointment = Optional.of(id)
            .map(appointmentRepository::findById)
            .map(c -> c.orElse(Appointment.builder().build()))
            .orElse(Appointment.builder().build());

    existingAppointment.setName(complaint.getName());
    existingAppointment.setDescription(complaint.getDescription());

    return appointmentRepository.save(existingAppointment);
  }
}
