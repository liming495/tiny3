FROM openjdk:11
VOLUME /tmp
ADD ./target/gateway.jar /gateway.jar
RUN bash -c 'touch /gateway.jar'
EXPOSE 8060
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/gateway.jar"]