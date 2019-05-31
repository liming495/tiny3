FROM java:8
VOLUME /tmp
ADD ./target/registry.jar /registry.jar
RUN bash -c 'touch /registry.jar'
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/registry.jar"]