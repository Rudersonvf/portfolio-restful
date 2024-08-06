#
# Build stage
#
FROM maven:3.8.6-openjdk-21 AS build
WORKDIR /home/app
COPY pom.xml .
COPY src /home/app/src
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:21-slim
WORKDIR /app
COPY --from=build /home/app/target/portfolio-restful-0.0.1-SNAPSHOT.jar /app/portfolio-restful.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/portfolio-restful.jar"]
