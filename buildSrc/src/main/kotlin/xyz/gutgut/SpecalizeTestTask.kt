package xyz.gutgut

import gradle.kotlin.dsl.accessors._559893c82cd6425715b0171cab518731.jacocoTestReport
import org.gradle.api.tasks.testing.Test

abstract class SpecializedTestTask : Test() {
  init {
    useJUnitPlatform()
    reports { junitXml.required.set(false) }
    systemProperty("gradle.build.dir", project.buildDir)
    finalizedBy(project.tasks.jacocoTestReport)
    group = "verification"
  }
}
