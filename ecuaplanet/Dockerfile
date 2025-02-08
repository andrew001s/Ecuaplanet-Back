FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/ecuaplanet-0.0.1-SNAPSHOT.jar ecuaplanet.jar
COPY .env /app/.env
COPY ecuaplanet/src/main/resources/PrivateKey.json /app/ecuaplanet/src/main/resources/PrivateKey.json
EXPOSE 8080
CMD ["java", "-jar", "ecuaplanet.jar"]
