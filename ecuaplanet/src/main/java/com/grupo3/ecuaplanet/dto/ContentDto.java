package com.grupo3.ecuaplanet.dto;

import java.util.List;

public class ContentDto {
  private List<PartDto> parts;

  public ContentDto(List<PartDto> parts) {
    this.parts = parts;
  }

  public List<PartDto> getParts() {
    return parts;
  }

  public void setParts(List<PartDto> parts) {
    this.parts = parts;
  }
}
