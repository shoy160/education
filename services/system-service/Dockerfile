FROM openjdk:8-alpine

MAINTAINER shoy160@qq.com

WORKDIR /publish

EXPOSE 5000

ADD ./education-system-service.jar ./app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dfile.encoding=utf-8", "-jar", "app.jar"]

CMD ["--spring.profiles.active=dev", "--server.port=5000"]
