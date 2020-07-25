package com.wellnes.testcommunicate.services.impl;

import com.wellnes.testcommunicate.exceptions.NotFoundException;
import com.wellnes.testcommunicate.models.entities.Appointment;
import com.wellnes.testcommunicate.models.entities.AppointmentType;
import com.wellnes.testcommunicate.models.entities.Doctor;
import com.wellnes.testcommunicate.models.entities.Symptom;
import com.wellnes.testcommunicate.models.inbounds.AppointmentInbound;
import com.wellnes.testcommunicate.repositories.AppointmentRepository;
import com.wellnes.testcommunicate.services.api.AppointmentService;
import com.wellnes.testcommunicate.services.api.AppointmentTypeService;
import com.wellnes.testcommunicate.services.api.DoctorService;
import com.wellnes.testcommunicate.services.api.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

  @Autowired
  private AppointmentRepository appointmentRepository;

  @Autowired
  private AppointmentTypeService appointmentTypeService;

  @Autowired
  private DoctorService doctorService;

  @Autowired
  private SymptomService symptomService;

  @Override
  public Page<Appointment> findAll(int page, int limit) {
    return appointmentRepository.findAll(PageRequest.of(page, limit));
  }

  @Override
  public Appointment findOne(int id) {

    return appointmentRepository.findById(id).orElseThrow(() -> new NotFoundException("Appointment not found"));
  }

  @Override
  public void delete(int id) {
    appointmentRepository.deleteById(id);
  }

  @Override
  public Appointment create(AppointmentInbound appointment) {
    return appointmentRepository.save(Appointment.builder()
            .appointmentType(appointmentTypeService.findById(appointment.getAppointmentTypeId()))
            .patientId(appointment.getPatientId())
            .prescriptionId(appointment.getPrescriptionId())
            .symptom(symptomService.findById(appointment.getSymptomId()))
            .doctor(doctorService.findById(appointment.getDoctorId()))
            .build());
  }

  @Override
  public Appointment update(int id, AppointmentInbound appointment) {
    Appointment existingAppointment = Optional.of(id)
            .flatMap(appointmentRepository::findById)
            .orElse(Appointment.builder().build());

    int patientId = Optional.ofNullable(appointment.getPatientId())
            .orElse(existingAppointment.getAppointmentId());
    int prescriptionId = Optional.ofNullable(appointment.getPrescriptionId())
            .orElse(existingAppointment.getPrescriptionId());
    AppointmentType appointmentType = Optional.ofNullable(appointment.getAppointmentTypeId())
            .map(appointmentTypeService::findById)
            .orElse(existingAppointment.getAppointmentType());
    Doctor doctor = Optional.ofNullable(appointment.getDoctorId())
            .map(doctorService::findById)
            .orElse(existingAppointment.getDoctor());
    Symptom symptom = Optional.ofNullable(appointment.getSymptomId())
            .map(symptomService::findById)
            .orElse(existingAppointment.getSymptom());

    existingAppointment.setPatientId(patientId);
    existingAppointment.setPrescriptionId(prescriptionId);
    existingAppointment.setAppointmentType(appointmentType);
    existingAppointment.setDoctor(doctor);
    existingAppointment.setSymptom(symptom);

    return appointmentRepository.save(existingAppointment);
  }
}
