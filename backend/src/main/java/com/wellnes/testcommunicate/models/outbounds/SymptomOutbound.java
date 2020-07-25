package com.wellnes.testcommunicate.models.outbounds;

import com.wellnes.testcommunicate.models.entities.Symptom;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SymptomOutbound {

  private int symptomId;

  private String description;

  private String level;

  public static SymptomOutbound of(Symptom symptom) {
    return SymptomOutbound.builder()
            .symptomId(symptom.getSymptomId())
            .description(symptom.getDescription())
            .level(symptom.getLevel())
            .build();
  }

}
