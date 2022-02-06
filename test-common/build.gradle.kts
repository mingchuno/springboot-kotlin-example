/**
 * This is a module for common testing related code we want to share between modules. e.g. kotest
 * ProjectConfig. Note that this `build.gradle.kts` should be kept simple with only plugin and
 * dependency definition (similar for other modules).
 */
plugins { id("sampleproject.kotlin-conventions") }

dependencies {
  // Because other module will use this module in their `testImplementation` so we should use
  // `implementation` here instead.
  implementation(libs.bundles.kotest)
  implementation(libs.kotest.extensions.spring)
}
