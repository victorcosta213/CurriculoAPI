#
# Build stage
#
FROM maven:3.9-eclipse-temurin-22-alpine AS build

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo pom.xml e o diretório src
COPY pom.xml ./
COPY src ./src

# Rode o Maven para compilar o projeto
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM eclipse-temurin:22-jdk-alpine

# Defina o diretório de trabalho
WORKDIR /app

# Copie o JAR gerado para o container
COPY --from=build /app/target/curriculo-0.0.1-SNAPSHOT.jar /app/curriculo.jar

# Comando para rodar o JAR
ENTRYPOINT ["java", "-jar", "curriculo.jar"]

