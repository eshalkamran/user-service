# Use the official image as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in docker
WORKDIR /app

# Copy the jar file into the docker image
COPY target/user-service-0.0.1-SNAPSHOT.jar /app/user-service.jar

# Set the startup command to run your binary
ENTRYPOINT ["java", "-jar", "/app/user-service.jar"]
