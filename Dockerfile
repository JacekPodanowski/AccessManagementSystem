# Użyj obrazu JDK 21 jako bazy
FROM eclipse-temurin:21-jdk-alpine

# Ustaw katalog roboczy
WORKDIR /app

# Skopiuj plik pom.xml i inne pliki wymagane do budowy
COPY pom.xml ./
COPY src ./src

# Pobierz zależności i zbuduj projekt
RUN ./mvnw clean package -DskipTests

# Skopiuj zbudowany plik JAR (znajduje się w target/)
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Punkt wejścia aplikacji
ENTRYPOINT ["java", "-jar", "/app.jar"]
