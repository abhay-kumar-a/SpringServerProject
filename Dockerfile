FROM openjdk:16.0.2
EXPOSE 8080
ADD target/spring-docker.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
