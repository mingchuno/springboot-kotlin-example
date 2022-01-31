plugins { id("sampleproject.app-conventions") }

dependencies {
  implementation(project(":lib"))
  implementation(libs.kotlinx.coroutines.core)
  runtimeOnly(libs.kotlinx.coroutines.reactor)
  implementation(libs.bundles.ktor.client)
  implementation(libs.kotlin.logging)
  implementation(libs.kotlinx.serialization.json)
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.springframework.boot:spring-boot-starter-web")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}
