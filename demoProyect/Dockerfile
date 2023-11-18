FROM openjdk:20-ea-1-jdk-oracle
VOLUME [ "/tmp" ]
EXPOSE 8080
ADD ./target/backend.jar backend-aws.jar
ENTRYPOINT ["java", "-jar", "/backend-aws.jar"]