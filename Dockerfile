# Use an official Java runtime as a parent image
FROM eclipse-temurin:23-jdk-alpine as builder

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle wrapper and the build files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Download dependencies and build the project
RUN chmod +x gradlew && ./gradlew build

# Start a new stage to create the final image
FROM eclipse-temurin:23-jre-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the previous stage
COPY --from=builder /app/build/libs/rag-0.0.1-SNAPSHOT.jar /app/rag-0.0.1-SNAPSHOT.jar

# Set the command to run the JAR file
CMD ["java", "-jar", "rag-0.0.1-SNAPSHOT.jar"]