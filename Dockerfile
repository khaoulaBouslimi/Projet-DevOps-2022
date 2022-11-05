FROM openjdk:11-jdk-alpine
ADD target/*.jar/ achat-1.0.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/achat-1.0.jar"]



#COPY is a dockerfile command that copies files from a local source location to a destination in the Docker container.
#ADD command is used to copy files/directories into a Docker image
