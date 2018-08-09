FROM openjdk:8-alpine As build-env
RUN apk update \
 && apk --no-cache add maven \
 && rm -rf /var/cache/apk/*
WORKDIR /app
ADD . /app
RUN mvn clean package -e

FROM openjdk:8-jre-alpine
RUN apk update \
 && apk --no-cache add git \
 && rm -rf /var/cache/apk/*

VOLUME /tmp

COPY config /config
COPY --from=build-env /app/target/app.jar /app.jar

ENV JAVA_OPTS="-Xmx128m -Xms128m"

ENTRYPOINT  if [ ! -e /config/.git ]; \
            then \
                cd /config && \
                git init && \
                git add . && \
                git -c user.name='SoftLeader' -c user.email='rd@softleader.com.tw' commit -m "initial"; \
            fi && \
            java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
