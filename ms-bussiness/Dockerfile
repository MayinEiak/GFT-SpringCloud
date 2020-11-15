FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
COPY ./wait-for ./wait-for
RUN apk add --no-cache bash
