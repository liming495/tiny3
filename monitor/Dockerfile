FROM java:8
VOLUME /tmp
ADD ./target/monitor.jar /monitor.jar
RUN bash -c 'touch /monitor.jar'
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/monitor.jar"]