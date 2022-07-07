FROM openjdk:11
ARG JAR_FILE=target/spring-docker.jar app.jar
COPY ${JAR_FILE} spring-docker.jar app.jar
ENTRYPOINT ["java","-jar","spring-docker.jar app.jar"]
