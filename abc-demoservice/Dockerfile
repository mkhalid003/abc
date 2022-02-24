FROM openjdk:8-jdk-alpine

RUN mkdir -p /app

COPY target/abc-demoservice-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java","-jar","/app/abc-demoservice-0.0.1-SNAPSHOT.jar"]