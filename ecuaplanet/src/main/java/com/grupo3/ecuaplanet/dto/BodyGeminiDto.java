package com.grupo3.ecuaplanet.dto;

public class BodyGeminiDto {
    
    private ContentDto contents;
    
    public BodyGeminiDto(ContentDto contents) {
        this.contents = contents;
    }

    public ContentDto getContents() {
        return contents;
    }

    public void setContents(ContentDto contents) {
        this.contents = contents;
    }



}
