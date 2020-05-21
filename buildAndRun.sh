#!/bin/sh
docker-compose down &&
mvn clean package -DskipTests
docker-compose build --no-cache &&
docker-compose up -d --force-recreate
sleep 1
