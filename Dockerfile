FROM maven:3-alpine

MAINTAINER XenonStack

# Creating Application Source Code Directory
RUN mkdir -p /usr/src/app

# Setting Home Directory for containers
WORKDIR /usr/src/app

# Copying src code to Container
COPY . /usr/src/app

# Building From Source Code
RUN mvn clean package -DskipTests

# Exposing Port
EXPOSE 8082

# Running Kotlin Application
CMD ["java", "-jar", "target/karate-beer-0.0.1-SNAPSHOT.jar"]
