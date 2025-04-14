# ビルドステージ
FROM gradle:8.5-jdk17 AS build
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle clean build --no-daemon

# 実行ステージ
FROM openjdk:17-jdk-slim
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=${PORT}"]
