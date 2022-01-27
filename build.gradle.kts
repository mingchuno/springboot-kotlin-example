import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.6.1"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm") version "1.6.10"
  kotlin("plugin.serialization") version "1.6.10"
  kotlin("plugin.spring") version "1.6.0"
  id("com.diffplug.spotless") version "6.0.5"
  id("io.gitlab.arturbosch.detekt").version("1.19.0")
}

group = "xyz.gutugt"

version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_11

repositories { mavenCentral() }

dependencies {
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
  runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.6.0")
  implementation("io.ktor:ktor-client-core:1.6.7")
  implementation("io.ktor:ktor-client-cio:1.6.7")
  implementation("io.ktor:ktor-client-serialization:1.6.7")
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("io.github.microutils:kotlin-logging:2.1.21")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
  kotlin { ktfmt("0.30") }
  kotlinGradle { ktfmt("0.30") }
}

detekt {
  buildUponDefaultConfig = true
  // FIXME: enable it later
  ignoreFailures = true
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "11"
  }
}

tasks.withType<Test> { useJUnitPlatform() }
