FROM softleader/build-env:jcconf2018 As build-env
WORKDIR /app
ADD . /app
RUN mvn clean package

FROM openjdk:8-jre-alpine
RUN apk update \
 && apk --no-cache add git tzdata \
 && ls /usr/share/zoneinfo \
 && cp /usr/share/zoneinfo/Asia/Taipei /etc/localtime  \
 && rm -rf /var/cache/apk/*

VOLUME /tmp

COPY --from=build-env /app/target/app.jar /app.jar

# 預留一個變數讓 docker 啟動時可以傳入更多的參數
ENV APP_OPTS=""

ENTRYPOINT ["/bin/sh", "-c", "java $APP_OPTS -Xmx128m -Xms128m -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]
