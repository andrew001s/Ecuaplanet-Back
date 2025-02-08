package com.grupo3.ecuaplanet.service;

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
        // Recuperar los objetos en la lista de Redis
        List<Object> messageJsonObjectList = redisTemplate.opsForList().range(key, 0, -1);

        // Si no hay mensajes en Redis, devolver una lista vacía
        if (messageJsonObjectList == null || messageJsonObjectList.isEmpty()) {
            return List.of(); // Devuelve una lista vacía
        }

        // Convertir los objetos de Redis a cadenas JSON
        List<String> messageJsonList = messageJsonObjectList.stream()
                .map(Object::toString) // Convierte cada objeto a cadena
                .collect(Collectors.toList());

        // Crear un ObjectMapper para deserializar las cadenas JSON a objetos Message
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            // Deserializa cada mensaje JSON a un objeto Message
            return messageJsonList.stream()
                    .map(json -> {
                        try {
                            // Deserializar cada cadena JSON a un objeto Message
                            return objectMapper.readValue(json, Message.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null; // Si ocurre un error de deserialización, devolver null
                        }
                    })
                    .filter(message -> message != null) // Filtrar los mensajes nulos (en caso de error de
                                                        // deserialización)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // En caso de error general, devolver null
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
            // Convertir el objeto Message a JSON
            String messageJson = objectMapper.writeValueAsString(message);

            // Insertar el mensaje en Redis (agregarlo al final de la lista)
            redisTemplate.opsForList().leftPush(keyredis, messageJson);
            System.out.println("Mensaje insertado en Redis: " + messageJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
