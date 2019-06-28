FROM openjdk:11
VOLUME /tmp
ADD ./target/auth-service.jar /auth-service.jar
RUN bash -c 'touch /auth-service.jar'
EXPOSE 5000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/auth-service.jar"]