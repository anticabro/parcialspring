# Etapa 1: Construcción del proyecto (usando una imagen con Maven)
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
# Copia primero el pom.xml para aprovechar la caché de Docker
COPY pom.xml .
COPY src ./src
# Construye el proyecto sin ejecutar pruebas
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final para ejecución
FROM eclipse-temurin:17
WORKDIR /app
# Copia el JAR generado desde la etapa de construcción
COPY --from=builder /app/target/*.jar app.jar
# Expone el puerto (ajusta si tu aplicación usa otro puerto)
EXPOSE 8094
# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]