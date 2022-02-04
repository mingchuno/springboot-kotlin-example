package xyz.gutgut

import org.gradle.api.tasks.testing.Test

abstract class SpecializedTestTask : Test() {
  init {
    useJUnitPlatform()
    reports { junitXml.required.set(false) }
    systemProperty("gradle.build.dir", project.buildDir)
    group = "verification"
  }
}
