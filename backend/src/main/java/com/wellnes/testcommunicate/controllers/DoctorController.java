package com.wellnes.testcommunicate.controllers;

import com.wellnes.testcommunicate.models.entities.Doctor;
import com.wellnes.testcommunicate.models.inbounds.DoctorInbound;
import com.wellnes.testcommunicate.models.outbounds.BaseResponse;
import com.wellnes.testcommunicate.models.outbounds.DataResponse;
import com.wellnes.testcommunicate.models.outbounds.PageDataResponse;
import com.wellnes.testcommunicate.models.outbounds.Paging;
import com.wellnes.testcommunicate.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/doctors")
public class DoctorController {

  @Autowired
  private DoctorService doctorService;

  @GetMapping
  public PageDataResponse<Doctor> searchDoctor(
          @RequestParam(required = false, defaultValue = "0")
          int page,
          @RequestParam(required = false, defaultValue = "10")
          int size,
          @RequestParam(required = false, defaultValue = "")
          String name
  ) {
    Page<Doctor> doctors = doctorService.searchDoctorByName(name, page, size);
    Paging paging = Paging.builder()
            .totalRecords(doctors.getTotalElements())
            .page(doctors.getPageable().getPageNumber())
            .size(doctors.getSize())
            .build();

    return PageDataResponse.<Doctor>dataBuilder()
            .code(200)
            .status("Success")
            .paging(paging)
            .data(doctors.getContent())
            .build();
  }

  @PostMapping
  public DataResponse<Doctor> createDoctor(
          @RequestBody
          DoctorInbound doctorInbound
  ) {
    return DataResponse.<Doctor>dataBuilder()
            .data(doctorService.createDoctor(doctorInbound))
            .status("Success")
            .code(200)
            .build();
  }

  @DeleteMapping(value = "/{doctorId}")
  public BaseResponse deleteDoctor(@PathVariable int doctorId) {
    doctorService.deleteDoctor(doctorId);
    return BaseResponse.builder()
            .code(200)
            .status("Success")
            .build();
  }

  @PutMapping(value = "/{doctorId}")
  public DataResponse<Doctor> updateDoctor(
          @PathVariable int doctorId,
          @RequestBody DoctorInbound doctorInbound
  ) {
    return DataResponse.<Doctor>dataBuilder()
            .code(200)
            .status("Success")
            .data(doctorService.updateDoctor(doctorId, doctorInbound))
            .build();
  }
}
