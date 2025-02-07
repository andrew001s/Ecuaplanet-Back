package com.grupo3.ecuaplanet.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.io.File; // Importa la clase File

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp initializeFirebase() throws IOException {
        if (FirebaseApp.getApps().isEmpty()) {
            System.out.println("Inicializando Firebase..."); // Mensaje al inicio

            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("PrivateKey.json");

            if (serviceAccount == null) {
                System.err.println("No se pudo encontrar PrivateKey.json en resources.");
                throw new IllegalStateException("No se pudo encontrar PrivateKey.json en resources.");
            } else {
                System.out.println("Archivo PrivateKey.json encontrado en resources.");

                // Imprime la ruta absoluta del archivo (para depuración)
                try {
                    File file = new File(getClass().getClassLoader().getResource("PrivateKey.json").getFile());
                    System.out.println("Ruta absoluta del archivo: " + file.getAbsolutePath());
                } catch (Exception e) {
                    System.err.println("Error al obtener la ruta absoluta del archivo: " + e.getMessage());
                }
            }


            try {
                FirebaseOptions options = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();

                System.out.println("Credenciales cargadas correctamente."); // Mensaje si las credenciales se cargan

                FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
                System.out.println("Firebase inicializado correctamente."); // Mensaje si Firebase se inicializa
                return firebaseApp;

            } catch (Exception e) {
                System.err.println("Error al inicializar Firebase: " + e.getMessage());
                throw e; // Re-lanza la excepción para que Spring Boot falle
            }


        }
        System.out.println("Firebase ya inicializado.  Devolviendo instancia existente."); // Si ya está inicializado
        return FirebaseApp.getInstance();
    }
}