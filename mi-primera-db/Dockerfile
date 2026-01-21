FROM ubuntu:latest
LABEL authors="robinson.nolasco"

ENTRYPOINT ["top", "-b"]

# ETAPA 1: @Maven Build con Java 21
# Usamos una imagen de Maven que ya incluya el JDK 21
FROM maven:3.9.5-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# ETAPA 2: @Run con Java 21
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]