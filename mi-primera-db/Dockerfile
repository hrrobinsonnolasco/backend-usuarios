FROM ubuntu:latest
LABEL authors="robinson.nolasco"

ENTRYPOINT ["top", "-b"]

# ETAPA 1: @Maven Build - Compilamos el código en la nube
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
# Copiamos tu código al servidor de compilación
COPY . .
# Ejecutamos Maven para crear el archivo .jar (saltando los tests para ir más rápido)
RUN mvn clean package -DskipTests

# ETAPA 2: @Run - Ejecutamos la aplicación
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Traemos el archivo generado en la Etapa 1
COPY --from=build /app/target/*.jar app.jar
# Encendemos la aplicación
ENTRYPOINT ["java","-jar","app.jar"]