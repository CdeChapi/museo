# Usa una imagen base de Java (corrigiendo la versión)
FROM openjdk:17-jdk-slim

# Configura el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR generado al contenedor
COPY target/ProyectoMuseo-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el contenedor
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]