FROM openjdk:14

ADD corona-service/target/corona-service-0.0.1-SNAPSHOT.jar corona-service-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "corona-service-0.0.1-SNAPSHOT.jar"]