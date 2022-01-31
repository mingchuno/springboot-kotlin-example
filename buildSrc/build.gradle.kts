plugins { `kotlin-dsl` }

repositories {
  gradlePluginPortal() // so that external plugins can be resolved in dependencies section
}

dependencies {
  implementation("com.diffplug.spotless:spotless-plugin-gradle:6.2.0")
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
  implementation("org.jetbrains.kotlin:kotlin-serialization:1.6.10")
  implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.19.0")
  implementation("org.springframework.boot:spring-boot-gradle-plugin:2.6.3")
  implementation("io.spring.gradle:dependency-management-plugin:1.0.11.RELEASE")
  implementation("org.jetbrains.kotlin:kotlin-allopen:1.6.10")
}
