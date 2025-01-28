package com.grupo3.ecuaplanet.dto;

public class RequestGeminiDto {
    private String text;

    public RequestGeminiDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
