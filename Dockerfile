# Utiliza una imagen base de Java (OpenJDK)
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo WAR de la aplicación al contenedor
COPY target/demo-0.0.1-SNAPSHOT.war app.war

# Expone el puerto en el que la aplicación escucha (el mismo que configuraste en Spring Boot)
EXPOSE 8082

# Comando para ejecutar la aplicación cuando el contenedor se inicie
ENTRYPOINT ["java", "-jar", "app.war"]