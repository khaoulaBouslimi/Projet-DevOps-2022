FROM openjdk:11-jdk-alpine
COPY target/*.jar /
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/achat-1.0.jar"]



#COPY target/*.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
#COPY is a docker file command that copies files from a local source location to a destination in the Docker container.
#ADD command is used to copy files/directories into a Docker image
