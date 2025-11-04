# ---- STAGE 1: Build the JAR ----
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy source code
COPY . .

# Build the application (skip tests for faster build)
RUN mvn clean package -DskipTests

# ---- STAGE 2: Run the JAR ----
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the built jar file
COPY --from=build /app/target/cityCare-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
