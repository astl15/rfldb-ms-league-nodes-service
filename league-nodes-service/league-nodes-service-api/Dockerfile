FROM openjdk:latest
ADD target/league-nodes-service-api-0.0.1-SNAPSHOT.jar league-nodes-service.jar
ENTRYPOINT ["java", "-jar", "league-nodes-service.jar"]
EXPOSE 8082