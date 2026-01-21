FROM ubuntu:latest
LABEL authors="robinson.nolasco"

ENTRYPOINT ["top", "-b"]

# @Docker Image: Usamos la versión de Java que tienes en tu proyecto
FROM eclipse-temurin:17-jdk-alpine

# @Jar Copy: Copiamos el archivo generado por Maven al contenedor
# Nota: Asegúrate que el nombre coincida con el que genera tu proyecto
COPY target/*.jar app.jar

# @Entrypoint: El comando que arranca tu Backend en el servidor
ENTRYPOINT ["java","-jar","/app.jar"]