FROM softleader/build-env:jcconf2018 As build-env
WORKDIR /app
ADD . /app
RUN mvn clean package

FROM openjdk:8-jre-alpine
RUN apk update \
 && apk --no-cache add git \
 && rm -rf /var/cache/apk/*

VOLUME /tmp

COPY --from=build-env /app/target/app.jar /app.jar

ENTRYPOINT ["/bin/sh", "-c", "java -Xmx128m -Xms128m -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]
