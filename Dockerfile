FROM adoptopenjdk/openjdk11:alpine-slim

MAINTAINER ytvnr

ARG JAR_FILE=target/*.jar

# cd /usr/local/runme
WORKDIR /usr/local/runme

# copy target/find-links.jar /usr/local/runme/app.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

# java -jar /usr/local/runme/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
