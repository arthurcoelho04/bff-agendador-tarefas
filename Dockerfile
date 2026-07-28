FROM gradle:8.14-jdk21-alpine AS build
WORKDIR /app
COPY . .
run gradle build --no-daemon

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/build/libs/*.jar /app/bff-gendador-tarefas.jar

EXPOSE 8083

CMD ["java", "-jar", "/app/bff-gendador-tarefas.jar"]
