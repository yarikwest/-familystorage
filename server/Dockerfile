FROM openjdk:8-jdk-alpine
MAINTAINER Yaroslav Zakhidnyi <yarikwest@meta.ua>

VOLUME /tmp

ARG JAR_FILE
COPY ${JAR_FILE} server-1.0.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/server-1.0.jar"]
