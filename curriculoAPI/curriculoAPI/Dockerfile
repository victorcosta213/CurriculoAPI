#
# Build stage
#
FROM maven:4.0-eclipse-temurin-22-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM eclipse-temurin:22-jdk-alpine
COPY --from=build /target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]