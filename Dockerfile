# Fase de build
FROM maven:latest AS build
LABEL authors="Vitor zucon"

# Fase de Build
WORKDIR /usr/src/app
COPY pom.xml /usr/src/app/
RUN mvn dependency:go-offline
COPY . /usr/src/app
RUN mvn package

# Fase de Execução
FROM openjdk:21-jdk-slim
WORKDIR /usr/src/app
COPY --from=build /usr/src/app/target/email-boot-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
