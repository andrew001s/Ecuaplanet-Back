package com.grupo3.ecuaplanet.dto;

public class CandidateDto {

  public CandidateDto(ContentDto content) {
    this.content = content;
  }

  private ContentDto content;

  public ContentDto getContent() {
    return content;
  }

  public void setContent(ContentDto content) {
    this.content = content;
  }
}
