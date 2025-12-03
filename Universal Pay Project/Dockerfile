# Build Stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Run Stage
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/u-pay-0.0.1-SNAPSHOT.jar upay.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "upay.jar"]


#mvn clean package -DskipTests
#docker build -t springboot-app .
#docker run -p 8080:8080 springboot-app
#
#