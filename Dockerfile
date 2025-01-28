# Użyj obrazu Javy jako podstawy
FROM eclipse-temurin:17-jdk AS build

# Ustaw katalog roboczy w kontenerze
WORKDIR /app

# Skopiuj pliki projektu
COPY . .

# Kompilacja aplikacji
RUN ./mvnw clean package -DskipTests

# Tworzenie finalnego obrazu
FROM eclipse-temurin:17-jre

# Ustaw katalog roboczy w kontenerze
WORKDIR /app

# Kopiowanie skompilowanego pliku JAR z poprzedniego etapu
COPY --from=build /app/target/*.jar app.jar

# Otwórz port aplikacji (zmień jeśli używasz innego)
EXPOSE 8080

# Uruchomienie aplikacji
ENTRYPOINT ["java", "-jar", "app.jar"]
