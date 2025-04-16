# --------- ビルドステージ ----------
FROM eclipse-temurin:17 AS build

WORKDIR /app

COPY --chown=gradle:gradle . /app

# gradlew を使って、Gradleがなくてもビルドできるように
RUN ./gradlew clean build --no-daemon

# --------- 実行ステージ ----------
FROM eclipse-temurin:17

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENV PORT=8080

ENTRYPOINT ["java", "-jar", "app.jar", "--server.address=0.0.0.0", "--server.port=${PORT}"]
