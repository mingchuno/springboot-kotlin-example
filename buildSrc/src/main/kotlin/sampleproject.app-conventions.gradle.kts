import xyz.gutgut.SpecializedTestTask

/**
 * This plugin extends "sampleproject.kotlin-conventions" and also added some spring related plugin
 * for ":app". Fat jar packing and publishing logic should also put in here.
 */
plugins {
  id("sampleproject.kotlin-conventions")
  id("org.springframework.boot")
  id("io.spring.dependency-management")
  kotlin("plugin.spring")
}

tasks.register<SpecializedTestTask>("testContract") {
  systemProperty("kotest.tags", "ContractTest")
}

tasks.register<SpecializedTestTask>("testApplication") {
  systemProperty("kotest.tags", "ApplicationTest")
}

tasks.register<SpecializedTestTask>("testUnit") {
  systemProperty("kotest.tags", "!ApplicationTest & !ContractTest")
}
