package com.wellnes.testcommunicate.models.outbounds;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppointmentDetailOutbound {

  private int appointmentId;

  private DoctorOutbound doctor;

  private int patientId;

  private int prescriptionId;

  private AppointmentTypeOutbound appointmentType;

  private SymptomOutbound symptom;

}
