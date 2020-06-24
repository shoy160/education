FROM openjdk:8-alpine

MAINTAINER shoy160@qq.com

WORKDIR /publish

EXPOSE 5000

ADD ./target/education-system-service.jar ./app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]

CMD ["--spring.profiles.active=test"]
