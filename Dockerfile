# STAGE 1: Assembling the artifact
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app

# Copy the dependencies file
COPY pom.xml .
# Copy the source code
COPY src ./src

# Run the build inside Docker
RUN mvn clean package -DskipTests

# STEP 2: Creating the final image for launch
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy only the finished JAR file from the previous step.
COPY --from=build /app/target/*.jar app.jar

# Specify the prod profile and run
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]