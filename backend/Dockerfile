FROM maven:3.9.8-eclipse-temurin-21
COPY . /app
WORKDIR /app
RUN mvn clean package
RUN mv target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]