FROM openjdk:17-jdk-slim AS build
WORKDIR /app
# Copy the JAR file from the local directory to the image
COPY target/demo5-0.0.1-SNAPSHOT.jar /app/demo.jar
# Run the application
ENTRYPOINT ["java", "-jar", "/app/demo.jar"]