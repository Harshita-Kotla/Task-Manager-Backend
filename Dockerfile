# Step 1: Use Maven to build the application
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and download dependencies (to cache layers)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build the JAR
COPY src ./src
RUN mvn clean package -DskipTests

# Step 2: Use a smaller JDK runtime image
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 5000 (as in application.properties)
EXPOSE 5000

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
