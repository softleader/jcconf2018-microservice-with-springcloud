FROM softleader/build-env:jcconf2018 As build-env
WORKDIR /app
ADD . /app
RUN mvn clean package

FROM openjdk:8-jre-alpine
RUN apk update \
 && apk --no-cache add git \
 && rm -rf /var/cache/apk/*

VOLUME /tmp

COPY config /config
COPY entrypoint.sh /entrypoint.sh
COPY --from=build-env /app/target/app.jar /app.jar

ENTRYPOINT ["/bin/sh", "/entrypoint.sh"]
EXPOSE 8888
