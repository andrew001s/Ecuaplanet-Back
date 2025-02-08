package com.grupo3.ecuaplanet.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo3.ecuaplanet.model.Message;

import jakarta.annotation.PostConstruct;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public List<Message> getMessages(String key) {
        List<Object> messageJsonObjectList = redisTemplate.opsForList().range(key, 0, -1);
        if (messageJsonObjectList == null || messageJsonObjectList.isEmpty()) {
            return List.of(); 
        }
        List<String> messageJsonList = messageJsonObjectList.stream()
                .map(Object::toString) 
                .collect(Collectors.toList());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            List<Message> messages = messageJsonList.stream()
                    .map(json -> {
                        try {
                            return objectMapper.readValue(json, Message.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null; 
                        }
                    })
                    .filter(message -> message != null)
                    .collect(Collectors.toList());
            Collections.reverse(messages);
            return messages;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostConstruct
    public void checkRedisConnection() {
        String pingResponse = redisTemplate.getConnectionFactory().getConnection().ping();
        System.out.println("Respuesta de Redis: " + pingResponse); // Debe devolver "PONG"
    }

    public void insertMessage(String key, Message message) {
        String keyredis = "chat:history:" + key;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String messageJson = objectMapper.writeValueAsString(message);
            redisTemplate.opsForList().leftPush(keyredis, messageJson);
            System.out.println("Mensaje insertado en Redis: " + messageJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
