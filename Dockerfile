FROM openjdk:21-jdk-slim
WORKDIR /app
COPY build/libs/ShoppingApplication-0.0.1-SNAPSHOT.jar /app/ShoppingApplication.jar
EXPOSE 8081
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "/app/ShoppingApplication.jar"]