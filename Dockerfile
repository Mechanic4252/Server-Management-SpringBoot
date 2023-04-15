FROM openjdk:11
ADD target/spring-server-docker.jar spring-server-docker.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "/spring-server-docker.jar"]
