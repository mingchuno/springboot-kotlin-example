# springboot-kotlin-example

## What is this?

A sample Kotlin Spring Boot project that showcase the following tech stack and how they integrate together into a
complete project. This repo can act as new project scaffolding reference. Feature includes:

- Gradle multi module project setup using `buildSrc` custom plugin to abstract and share logic.
- Gradle version catalogs showcase centralized project dependency management.
- Spring Boot project in Kotlin using Spring WebMvc with simple coroutine showcase.
- Showcase different Spring configuration property in different envs and override. (default, testing, production)
- Showcase application log level config w/o messing with xml.
- kotest and mockk as our testing framework with integration to Spring Boot.
- Integrate `ktfmt` and `detekt` for code quality checking. (`detekt` not enabled by default)
- Different test flavours including unit test, contract test with external depns and application integration test.
- Full Intellij integration required only 2 plugins installed.

## Get started

```bash
./gradlew check # compile the project, run `detekt`, `spotlessCheck` and `test`
# enjoy different test falvours with the following tasks
`./gradlew testUnit`
`./gradlew testContract`
`./gradlew testApplication`
```

## Intellij integration

Install the following plugin in your Intellij

* `ktfmt`
* `kotest` (https://kotest.io/docs/intellij/intellij-plugin.html)

## TODOs

- [ ] Fix gradle multi-module plugin version management cannot use new version catalogs feature directly.
- [ ] Fix JUnit xml report generation with kotest.
- [ ] Replace Spring Boot WebMvc for WebFlux Reactor for better concurrent processing capability (True async,
  non-blocking IO with back pressure).
- [ ] Dockerlize and deployment to production.
- [ ] CI add JUnit test report artifact upload.
