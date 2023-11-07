FROM openjdk:20-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ./target/ingestion-service-1.0-SNAPSHOT.jar ingestion-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/ingestion-service.jar"]
