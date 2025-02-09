FROM openjdk:17-jdk-slim
WORKDIR /app
COPY .env /app/.env
COPY PrivateKey.json /app/src/main/resources/PrivateKey.json
COPY target/ecuaplanet-0.0.1-SNAPSHOT.jar ecuaplanet.jar
EXPOSE 8080
CMD ["java", "-jar", "ecuaplanet.jar"]