FROM maven:3-jdk-8-alpine
WORKDIR /app
ADD . /app
RUN mvn clean package -DskipTests && rm -rf /app/*
