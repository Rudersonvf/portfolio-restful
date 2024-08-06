FROM openjdk:21-slim-bookworm

WORKDIR /app

COPY target/portfolio-restful-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/portfolio-restful-0.0.1-SNAPSHOT.jar"]
