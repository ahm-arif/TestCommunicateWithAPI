package com.wellnes.testcommunicate.models.inbounds;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorInbound {
  private String name;
  private String specialization;
}
