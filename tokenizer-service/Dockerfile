# Build stage
FROM maven:3.8.4-openjdk-17 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

#Run stage
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/tokenizer-service-*.jar tokenizer-service.jar
CMD ["java", "-jar", "tokenizer-service.jar"]
