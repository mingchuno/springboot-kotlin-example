import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.6.1"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm") version "1.6.0"
  kotlin("plugin.spring") version "1.6.0"
  id("com.diffplug.spotless") version "6.0.5"
  id("io.gitlab.arturbosch.detekt").version("1.19.0")
}

group = "xyz.gutugt"

version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_11

repositories { mavenCentral() }

dependencies {
  implementation("org.http4k:http4k-core:4.17.5.0")
  implementation("org.http4k:http4k-client-jetty:4.17.5.0")
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("io.github.microutils:kotlin-logging:2.1.21")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
  kotlin { ktfmt("0.30") }
  kotlinGradle { ktfmt("0.30") }
}

detekt {
  buildUponDefaultConfig = true
  ignoreFailures = true
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "11"
  }
}

tasks.withType<Test> { useJUnitPlatform() }
