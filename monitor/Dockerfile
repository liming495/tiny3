FROM java:8
VOLUME /tmp
ADD ./target/monitor.jar /monitor.jar
RUN bash -c 'touch /monitor.jar'
EXPOSE 8040
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/monitor.jar"]