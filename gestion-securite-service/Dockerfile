# ==========================================
# STAGE 1: BUILD (Compilation de l'app)
# ==========================================
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copie les fichiers Maven
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Télécharge les dépendances (mise en cache si pom.xml ne change pas)
RUN ./mvnw dependency:go-offline -B

# Copie le code source
COPY src ./src

# Build l'application (crée le fichier .jar)
RUN ./mvnw clean package -DskipTests

# ==========================================
# STAGE 2: RUNTIME (Exécution de l'app)
# ==========================================
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Crée un utilisateur non-root pour la sécurité
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copie uniquement le JAR depuis le stage de build
COPY --from=build /app/target/*.jar app.jar

# Expose le port 8080
EXPOSE 8080

# Healthcheck (vérifie que l'app répond)
HEALTHCHECK --interval=30s --timeout=3s --start-period=40s \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8080/actuator/health || exit 1

# Lance l'application
ENTRYPOINT ["java", "-jar", "app.jar"]