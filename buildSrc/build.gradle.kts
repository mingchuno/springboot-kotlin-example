/**
 * Main role of this file is to define the plugin coordinates and version since we cannot specify
 * them as usual in plugin file under `src/` (This is how `buildSrc/` design).
 */
plugins { `kotlin-dsl` }

repositories {
  gradlePluginPortal() // so that external plugins can be resolved in dependencies section
}

dependencies {
  implementation(llibs.plugin.spotless)
  implementation(llibs.plugin.detekt)
  implementation(llibs.plugin.ksp)
  implementation(llibs.plugin.spring)
  implementation(llibs.plugin.spring.dependency.management)
  implementation(llibs.plugin.kotlin.gradle)
  implementation(llibs.plugin.kotlin.serialization)
  implementation(llibs.plugin.kotlin.allopen)
}
