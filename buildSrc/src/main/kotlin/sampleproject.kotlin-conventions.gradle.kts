/**
 * This is where you usual "build.gradle.kts" goes to when using multi modules build. This is
 * actually a plugin which you can use in any of your modules. This
 * "sampleproject.kotlin-conventions" define the basic build setting for other to extend such as
 * integrating spotless/ktfmt and detekt, define JVM toolchain/compiled byte code version, using
 * JUnit platform for testing. You name it. Common gradle setting should be put in here
 */
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  base
  kotlin("jvm")
  kotlin("plugin.serialization")
  id("com.diffplug.spotless")
  id("io.gitlab.arturbosch.detekt")
  id("com.google.devtools.ksp")
}

group = "xyz.gutugt"

version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_11

repositories { mavenCentral() }

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
  kotlin {
    ktfmt("0.30")
    // For arrow-optic integration. Omit this if you are not using ksp
    targetExclude("build/generated/ksp/**")
  }

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

tasks.withType<Test> {
  useJUnitPlatform()
  reports { junitXml.required.set(false) }
  systemProperty("gradle.build.dir", project.buildDir)
}

// For arrow-optic integration. Omit this if you are not using ksp
kotlin {
  sourceSets.main { kotlin.srcDir("build/generated/ksp/main/kotlin") }
  sourceSets.test { kotlin.srcDir("build/generated/ksp/test/kotlin") }
}
