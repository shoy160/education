FROM openjdk:8-alpine

MAINTAINER shoy160@qq.com

WORKDIR /publish

EXPOSE 5000

ENV EDU_MODE "test"
ENV EDU_NOCAS_GROUP "EDU_TEST"

ADD ./education-user-service.jar ./app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom -Duser.timezone=Asia/Shanghai -Dfile.encoding=utf-8", "-jar", "app.jar"]

CMD ["--spring.profiles.active=${EDU_MODE}", "--server.port=5000", "--spring.cloud.nacos.discovery.group=${EDU_NOCAS_GROUP}"]
