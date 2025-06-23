FROM eclipse-temurin:21-jdk-alpine

LABEL authors="gosuto-san"

WORKDIR /app

COPY /target/product.jar ./product.jar

EXPOSE 8084

CMD [ "java", "-jar", "product.jar" ]