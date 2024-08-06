# Use a imagem oficial do OpenJDK 21 como base
FROM openjdk:21-slim-bookworm

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo .jar da aplicação para o diretório de trabalho
COPY target/portfolio-restful-0.0.1-SNAPSHOT.jar /app/

# Exponha a porta que a aplicação irá usar
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app/portfolio-restful-0.0.1-SNAPSHOT.jar"]
