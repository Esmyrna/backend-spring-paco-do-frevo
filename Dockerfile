FROM openjdk:17
COPY backend-spring-paco-do-frevo/target/paco-do-frevo-0.0.1-SNAPSHOT.jar /app/paco-do-frevo.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "paco-do-frevo.jar"]