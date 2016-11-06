FROM frolvlad/alpine-oraclejdk8:slim
ADD catalogue-service-1.0.jar catalogue-service.jar
RUN sh -c 'touch /catalogue-service.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/catalogue-service.jar"]
