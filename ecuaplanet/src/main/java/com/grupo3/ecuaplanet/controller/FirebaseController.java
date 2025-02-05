package com.grupo3.ecuaplanet.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.grupo3.ecuaplanet.service.FirebaseAuthService;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class FirebaseController {

    @Autowired
    private FirebaseAuthService firebaseAuthService;
    private static final Logger logger = LoggerFactory.getLogger(FirebaseController.class);
    @GetMapping("/preferences")
    public ResponseEntity<?> getUserPreferences(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        logger.info("Token recibido: {}", token);
        try {
            String uid = firebaseAuthService.verifyToken(token);
            logger.info("Token recibido: {}", uid);
            Map<String, Object> userData = firebaseAuthService.getUserDataFromFirestore(uid);

            if (userData != null) {
                logger.info("Datos del usuario recibidos de Firestore: {}", userData);
                return ResponseEntity.ok(userData); // Devuelve el JSON del usuario
            } else {
                return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body("Usuario no encontrado en Firestore");
            }
        } catch (FirebaseAuthException e) {
            return ResponseEntity.status(HttpStatus.SC_UNAUTHORIZED).body("Token inválido");
        } catch (ExecutionException | InterruptedException e) {
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body("Error consultando Firestore");
        }
    }

    @GetMapping("/test")
    public ResponseEntity<String> testApi() {
        return ResponseEntity.ok("API funcionando correctamente");
    }
}