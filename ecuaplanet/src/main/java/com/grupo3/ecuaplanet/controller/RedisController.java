package com.grupo3.ecuaplanet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.ecuaplanet.model.Message;
import com.grupo3.ecuaplanet.service.RedisService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "*")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/history")
    public List<Message> getChatHistory(@RequestParam String key) {
        return redisService.getMessages(key);
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody Message message) {
        String key = message.getUser();
        redisService.insertMessage(key, message);

        return "Mensaje enviado";
    }
}
