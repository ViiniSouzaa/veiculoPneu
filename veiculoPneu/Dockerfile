FROM openjdk:17-jdk-slim
RUN mkdir /app
WORKDIR /app
COPY . .
RUN chmod +x ./mvnw
RUN ./mvnw clean install -DskipTests
RUN cp target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]