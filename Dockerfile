FROM eclipse-temurin:21-jdk-alpine

LABEL authors="gosuto-san"

WORKDIR /app

COPY /target/product.jar ./product.jar

EXPOSE 9090

CMD [ "java", "-jar", "product.jar" ]