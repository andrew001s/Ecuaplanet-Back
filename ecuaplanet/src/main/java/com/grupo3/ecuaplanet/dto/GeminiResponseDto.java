package com.grupo3.ecuaplanet.dto;

import java.util.List;

public class GeminiResponseDto {

    private List<CandidateDto> candidates;

    public List<CandidateDto> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<CandidateDto> candidates) {
        this.candidates = candidates;
    }
}
