package com.wellnes.testcommunicate.services.impl;

import com.wellnes.testcommunicate.models.entities.Appointment;
import com.wellnes.testcommunicate.models.inbounds.AppointmentInbound;
import com.wellnes.testcommunicate.repositories.AppointmentRepository;
import com.wellnes.testcommunicate.services.api.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

  private final AppointmentRepository appointmentRepository;

  public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
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
  public Appointment create(AppointmentInbound complaint) {
    return appointmentRepository.save(Appointment.builder()
            .build());
  }

  @Override
  public Appointment update(int id, AppointmentInbound complaint) {
    Appointment existingAppointment = Optional.of(id)
            .map(appointmentRepository::findById)
            .map(c -> c.orElse(Appointment.builder().build()))
            .orElse(Appointment.builder().build());

    return appointmentRepository.save(existingAppointment);
  }
}
