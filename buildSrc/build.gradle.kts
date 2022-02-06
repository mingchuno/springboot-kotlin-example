/**
 * Main role of this file is to define the plugin coordinates and version since we cannot specify
 * them as usual in plugin file under `src/` (This is how `buildSrc/` design).
 */
plugins { `kotlin-dsl` }

repositories {
  gradlePluginPortal() // so that external plugins can be resolved in dependencies section
}

// TODO: Still need to figure out how to use Gradle version catalogs here..
// https://melix.github.io/blog/2021/03/version-catalogs-faq.html#_but_how_can_i_use_the_catalog_in_plugins_defined_in_buildsrc
dependencies {
  implementation("com.diffplug.spotless:spotless-plugin-gradle:6.2.0")
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
  implementation("org.jetbrains.kotlin:kotlin-serialization:1.6.10")
  implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.19.0")
  implementation("org.springframework.boot:spring-boot-gradle-plugin:2.6.3")
  implementation("io.spring.gradle:dependency-management-plugin:1.0.11.RELEASE")
  implementation("org.jetbrains.kotlin:kotlin-allopen:1.6.10")
  implementation("com.google.devtools.ksp:symbol-processing-gradle-plugin:1.6.10-1.0.2")
}
