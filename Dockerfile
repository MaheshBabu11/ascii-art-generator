FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY target/ascii-art-generator-0.0.1-SNAPSHOT.jar ascii-art-generator.jar
ENTRYPOINT ["java","-jar","/ascii-art-generator.jar"]
