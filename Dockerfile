FROM maven:3.8.6-openjdk-8-slim

ADD . /usr/local/src

WORKDIR /usr/local/src

#ARG will be overrided by build-arg
ARG profile=dev
RUN echo ${profile}

#ENV will not be overrided by build-arg
#ENV profile=dev
#RUN echo ${profile}

#docker build -t docker-compose-demo:maven --build-arg profile=test .
RUN mvn clean package -Dmaven.test.skip=true -P ${profile}

EXPOSE 8080

#ENTRYPOINT java -jar /opt/app.jar
ENTRYPOINT java -jar target/docker-compose-demo-0.0.1-SNAPSHOT.jar