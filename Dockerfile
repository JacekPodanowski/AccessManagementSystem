# Użyj obrazu OpenJDK 21 jako bazy
FROM eclipse-temurin:21-jre-alpine

# Ustaw katalog roboczy w kontenerze
WORKDIR /app

# Skopiuj plik JAR do kontenera
COPY target/AccessManagementSystem-0.0.1-SNAPSHOT.jar app.jar

# Ustawienie portu (Cloud Run automatycznie przydziela PORT)
ENV PORT 8080
EXPOSE 8080

# Uruchom aplikację Spring Boot
ENTRYPOINT ["java", "-jar", "/app.jar"]
