FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
RUN chmod +x gradlew
RUN ./gradlew bootJar --no-daemon

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 3000
ENTRYPOINT ["java", "-jar", "app.jar"]






# ===== STEG 1: BYGG APPEN =====
# Java 21 JDK = kan bygga Java-kod. Steget heter "build" så steg 2 kan hämta härifrån.
FROM eclipse-temurin:21-jdk AS build

# Skapar mappen /app inne i imagen och ställer sig där.
WORKDIR /app

# Kopierar hela projektet (.) från datorn till /app (.) i imagen.
COPY . .

# Gör gradlew körbar. Behövs eftersom Windows tappar den markeringen.
RUN chmod +x gradlew

# Bygger appen till en .jar-fil. Hamnar i /app/build/libs/.
RUN ./gradlew bootJar --no-daemon


# ===== STEG 2: KÖR APPEN =====
# Java 21 JRE = kan bara köra, mindre image. Allt från steg 1 är borta här.
FROM eclipse-temurin:21-jre

# Ny /app-mapp, eftersom steg 2 börjar tomt.
WORKDIR /app

# Hämtar bara .jar-filen från steg 1 och döper den till app.jar.
COPY --from=build /app/build/libs/*.jar app.jar

# Dokumenterar att appen lyssnar på port 3000 (öppnar inget själv).
EXPOSE 3000

# Startar appen varje gång en container startar. Listan gör att stopp fungerar snyggt.
ENTRYPOINT ["java", "-jar", "app.jar"]