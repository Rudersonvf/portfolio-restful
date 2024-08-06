# Use uma imagem base com o JDK 21
FROM openjdk:21-jdk

# Define o diretório de trabalho
WORKDIR /app

# Copia o projeto para o container
COPY . .

# Configura permissões para o Maven Wrapper
RUN chmod +x ./mvnw

# Executa o Maven para construir o projeto
RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install

# Define o comando de entrada para iniciar o aplicativo
CMD ["java", "-Dserver.port=$PORT", "-jar", "target/*jar"]
