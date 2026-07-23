FROM eclipse-temurin:24-jdk

WORKDIR /app

COPY build/libs/bff-gendador-tarefas-0.0.1-SNAPSHOT.jar /app/bff-gendador-tarefas.jar

EXPOSE 8083

CMD ["java", "-jar", "bff-gendador-tarefas.jar"]
