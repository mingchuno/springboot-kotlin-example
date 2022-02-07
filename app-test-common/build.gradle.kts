plugins { id("sampleproject.app-conventions") }

dependencies {
  implementation(project(":common"))
  implementation(project(":app"))
  implementation(project(":test-common"))
  implementation(libs.kotlinx.coroutines.core)
  implementation(libs.kotlin.logging)
  implementation(libs.kotlinx.serialization.json)
  implementation(libs.arrow.optics)
  ksp(libs.arrow.optics.ksp)
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-test")
  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
  implementation(libs.bundles.kotest)
  implementation(libs.kotest.extensions.spring)
  implementation(libs.mockk)
  implementation(libs.springmockk)
}
