#!/bin/bash

# Run Gradle build
./gradlew build

# Build Docker image with Jib
./gradlew jibDockerBuild

# Run Docker Compose
docker compose up -d