FROM java:8
VOLUME /tmp
ADD ./target/zipkin.jar /zipkin.jar
RUN bash -c 'touch /zipkin.jar'
EXPOSE 9411
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/zipkin.jar"]