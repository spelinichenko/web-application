FROM openjdk:20
MAINTAINER Stepan Pelinichenko
COPY target/First-Java-Spring-Project-0.0.1-SNAPSHOT.jar pastebox.jar
ENTRYPOINT ["java", "-jar", "/pastebox.jar"]
