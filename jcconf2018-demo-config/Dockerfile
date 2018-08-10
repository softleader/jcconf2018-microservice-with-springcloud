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
COPY entrypoint.sh /usr/local/bin/entrypoint.sh
COPY --from=build-env /app/target/app.jar /app.jar

ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]