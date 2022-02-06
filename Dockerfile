FROM openjdk:11.0.14-oracle as build

COPY . .

RUN ./gradlew clean :app:assemble --no-daemon

FROM openjdk:11.0.14-jre

WORKDIR /app

COPY --from=build ./app/build/libs/app-*-SNAPSHOT.jar ./app.jar

CMD ["java", "-Dspring.profiles.active=production", "-jar", "app.jar"]