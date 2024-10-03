#
# Build stage
#
FROM maven:3.9-eclipse-temurin-22-alpine AS build
WORKDIR /app
COPY pom.xml ./
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM eclipse-temurin:22-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/curriculo-0.0.1-SNAPSHOT.jar vcm.jar
ENTRYPOINT ["java", "-jar", "vcm.jar"]
