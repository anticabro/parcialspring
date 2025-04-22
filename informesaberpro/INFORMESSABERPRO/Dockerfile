# Usa una imagen base con Java 17 (ojo, dijiste Java 20 pero estás usando Temurin 17)
FROM eclipse-temurin:17 AS builder

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia todo el proyecto al contenedor
COPY . .

# ✅ Dale permisos de ejecución al wrapper de Maven
RUN chmod +x mvnw

# ✅ Compila la aplicación sin correr los tests
RUN ./mvnw clean package -DskipTests

# Segunda etapa: solo incluye el jar final
FROM eclipse-temurin:17

WORKDIR /app

# Copia el jar construido desde la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Expón el puerto que tu app usa
EXPOSE 8094

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
