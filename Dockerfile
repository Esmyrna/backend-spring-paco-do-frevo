# Use a imagem base do OpenJDK para Java 8
FROM openjdk:17

# Copie o arquivo JAR para o contêiner
COPY target/paco-do-frevo-0.0.1-SNAPSHOT.jar /app/paco-do-frevo.jar

# Defina o diretório de trabalho
WORKDIR /app

# Exponha a porta utilizada pela aplicação Spring Boot
EXPOSE 8080

# Comando para executar o JAR
CMD ["java", "-jar", "paco-do-frevo.jar"]