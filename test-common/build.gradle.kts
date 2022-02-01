plugins { id("sampleproject.kotlin-conventions") }

dependencies {
  implementation(libs.bundles.kotest)
  implementation(libs.kotest.extensions.spring)
}
