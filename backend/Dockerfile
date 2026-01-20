FROM openjdk:17-jdk-alpine
RUN mkdir -p /app/uploads
ADD target/bank_app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bank_app.jar"]