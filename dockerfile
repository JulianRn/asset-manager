FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY build/libs/Finance-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]