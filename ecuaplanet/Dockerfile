# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo .env.template y renombrarlo como .env
COPY ecuaplanet/.env.template /app/.env

# Copiar el archivo PrivateKeyTemplate.json
COPY ecuaplanet/src/main/resources/PrivateKeyTemplate.json /app/PrivateKey.json

# Copiar el archivo JAR
COPY target/ecuaplanet-0.0.1-SNAPSHOT.jar /app/ecuaplanet.jar

# Exponer el puerto 8080
EXPOSE 8080

# Configurar la ejecución del contenedor
ENTRYPOINT ["java", "-jar", "/app/ecuaplanet.jar"]
