FROM amd64/openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/mypage-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS /app.jar