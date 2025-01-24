FROM openjdk:17-oracle
COPY target/demo-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "demo.jar"]