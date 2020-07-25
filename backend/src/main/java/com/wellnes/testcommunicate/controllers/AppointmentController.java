package com.wellnes.testcommunicate.controllers;

import com.wellnes.testcommunicate.models.entities.Appointment;
import com.wellnes.testcommunicate.models.inbounds.AppointmentInbound;
import com.wellnes.testcommunicate.models.outbounds.wrapper.BaseResponse;
import com.wellnes.testcommunicate.models.outbounds.wrapper.DataResponse;
import com.wellnes.testcommunicate.models.outbounds.wrapper.PageDataResponse;
import com.wellnes.testcommunicate.models.outbounds.wrapper.Paging;
import com.wellnes.testcommunicate.services.api.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/complaints")
public class AppointmentController {

  private final AppointmentService appointmentService;

  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @GetMapping
  public PageDataResponse<Appointment> getAllComplaint(
          @RequestParam(required = false,
                  defaultValue = "0")
                  int page,
          @RequestParam(required = false,
                  defaultValue = "10")
                  int size
  ) {
    Page<Appointment> complaints = appointmentService.findAll(page, size);
    Paging paging = Paging.builder()
            .page(complaints.getPageable().getPageNumber())
            .size(complaints.getSize())
            .totalRecords(complaints.getTotalElements())
            .build();

    return PageDataResponse.<Appointment>dataBuilder()
            .code(200)
            .status("Success")
            .paging(paging)
            .data(complaints.get().collect(Collectors.toList()))
            .build();
  }

  @PostMapping
  public DataResponse<Appointment> createComplaint(
          @RequestBody AppointmentInbound appointmentInbound
  ) {
    Appointment appointment = appointmentService.create(appointmentInbound);
    return DataResponse.<Appointment>dataBuilder()
            .code(200)
            .status("Success")
            .data(appointment)
            .build();
  }

  @DeleteMapping(value = "/{complaintId}")
  public BaseResponse deleteComplaint(
          @PathVariable int complaintId
  ) {
    appointmentService.delete(complaintId);
    return BaseResponse.builder()
            .code(200)
            .status("Success")
            .build();
  }

  @PutMapping(value = "/{complaintId}")
  public DataResponse<Appointment> updateComplaint(
          @PathVariable int complaintId,
          @RequestBody AppointmentInbound appointmentInbound
  ) {
    Appointment appointment = appointmentService.update(complaintId, appointmentInbound);
    return DataResponse.<Appointment>dataBuilder()
            .code(200)
            .status("Success")
            .data(appointment)
            .build();
  }

}
