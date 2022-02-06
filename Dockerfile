FROM openjdk:11.0.14-oracle as build

COPY . .

RUN ./gradlew clean assemble --no-daemon

FROM openjdk:11.0.14-jre

WORKDIR /app

COPY --from=build ./app/build/libs/app-*-SNAPSHOT.jar ./app.jar

CMD ["java", "-jar", "app.jar", "-Dspring.profiles.active=production"]