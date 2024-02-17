FROM openjdk
LABEL maintainer = "abc@mail.com"
EXPOSE 8090
WORKDIR /app
COPY target/docker_demo.jar /app/docker_demo.jar
ENTRYPOINT ["java","-jar","docker_demo.jar"]