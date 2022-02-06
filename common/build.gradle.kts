plugins { id("sampleproject.kotlin-conventions") }

dependencies {
  testImplementation(libs.bundles.kotest)
  testImplementation(project(":test-common"))
}
