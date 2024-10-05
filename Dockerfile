FROM openjdk:21-jdk-slim

LABEL authors="G00406014@atu.ie"

WORKDIR /app
COPY target/week2_refresher-0.0.1-SNAPSHOT.jar /app/product-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/product-service.jar"]
