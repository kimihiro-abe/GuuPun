# ビルドステージ（GradleとJDK）
FROM gradle:8.5-jdk17 AS build
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle clean build --no-daemon

# 実行ステージ（軽量なJDKだけ）
FROM openjdk:17-jdk-slim
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

