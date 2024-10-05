FROM ubuntu:latest
LABEL authors="G00406014@atu.ie"
WORKDIR /app
COPY target/product-service.jar /app/product-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "product-service.jar"]
