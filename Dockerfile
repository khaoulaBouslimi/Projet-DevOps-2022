FROM openjdk
COPY target/*.jar /
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/achat-1.0.jar"]
