package com.wellnes.testcommunicate.models.outbounds;

import com.wellnes.testcommunicate.models.entities.DoctorCategory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoctorCategoryOutbound {

  private int doctorCategoryId;

  private String doctorCategoryCode;

  private String doctorCategoryName;

  public static DoctorCategoryOutbound of(DoctorCategory doctorCategory) {
    return DoctorCategoryOutbound.builder()
            .doctorCategoryId(doctorCategory.getDoctorCategoryId())
            .doctorCategoryCode(doctorCategory.getDoctorCategoryCode())
            .doctorCategoryName(doctorCategory.getDoctorCategoryName())
            .build();
  }

}
