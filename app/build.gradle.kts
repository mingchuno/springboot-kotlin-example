plugins { id("sampleproject.app-conventions") }

dependencies {
  implementation(project(":common"))
  implementation(libs.kotlinx.coroutines.core)
  runtimeOnly(libs.kotlinx.coroutines.reactor)
  implementation(libs.bundles.ktor.client)
  implementation(libs.kotlin.logging)
  implementation(libs.kotlinx.serialization.json)
  implementation(libs.arrow.optics)
  ksp(libs.arrow.optics.ksp)
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.springframework.boot:spring-boot-starter-web")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
  testImplementation(libs.bundles.kotest)
  testImplementation(libs.kotest.extensions.spring)
  testImplementation(project(":test-common"))
  testImplementation(libs.mockk)
  testImplementation(libs.springmockk)
}
