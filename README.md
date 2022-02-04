# springboot-kotlin-example

## TODOs

- [x] config and spring profile
- [x] logging
- [ ] multiple layer testing spec
    - How to override property source?
- [x] multiple gradle module support
- [x] ktfmt and detekt
- [ ] spring annotation and DI config
- [ ] testing, mocking and assertion
    - [ ] fix Junit report generation
    - [ ] upload artifact to CI
- [ ] async and coroutine support
    - [ ] Switch to Spring WebFlux instead
- [x] Gradle version catalogs
    - [ ] Fix using plugin inside `buildSrc`
- [x] HTTP client
    - [ ] DI on HTTP client?
- [ ] Dockerize and deploy?
- [ ] Testing issue
    - kottest + spring DI not working on other module
    - Junit + spring DI work on other module

## Intellij integration

Install the following plugin in your Intellij

* `ktfmt`
* `kotest` (https://kotest.io/docs/intellij/intellij-plugin.html)

## Get started

```bash
./gradlew check
```