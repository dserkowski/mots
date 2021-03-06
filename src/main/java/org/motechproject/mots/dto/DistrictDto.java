package org.motechproject.mots.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class DistrictDto {

  @Getter
  @Setter
  private String id;

  @Getter
  @Setter
  private String name;

  @Getter
  @Setter
  private List<ChiefdomDto> chiefdoms;
}
