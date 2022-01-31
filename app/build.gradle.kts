plugins { id("sampleproject.app-conventions") }

dependencies {
  implementation(project(":lib"))
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
