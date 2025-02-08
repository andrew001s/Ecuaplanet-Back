FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY src/main/resources/PrivateKey.json /app/src/main/resources/PrivateKey.json
COPY ecuaplanet/.env /app/.env
COPY target/ecuaplanet-0.0.1-SNAPSHOT.jar ecuaplanet.jar
EXPOSE 8080
CMD ["java", "-jar", "ecuaplanet.jar"]