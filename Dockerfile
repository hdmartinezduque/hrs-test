FROM maven:3.9.6-eclipse-temurin-17 as builder

WORKDIR /build

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

RUN mkdir -p /code && chmod 777 /code
WORKDIR /code

COPY --from=builder /build/target/hrs-test-jar-with-dependencies.jar app.jar

COPY rules.json .
COPY readings.json .
COPY readings.yml .

ENV READINGS_FILE=readings.json
ENV RULES_FILE=rules.json
ENV OUTPUT_DIR=/code

CMD ["java", "-jar", "app.jar"]
