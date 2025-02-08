package com.grupo3.ecuaplanet.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QdrantConfig {

    @Value("${qdrant.url}")
    private String qdrantUrl;

    public String getQdrantUrl() {
        return qdrantUrl;
    }
    
}
