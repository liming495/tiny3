FROM java:8
VOLUME /tmp
ADD ./target/config.jar /config.jar
RUN bash -c 'touch /config.jar'
EXPOSE 8888
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/config.jar"]