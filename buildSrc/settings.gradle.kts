enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
  // `llibs` is not a typo. using `libs` seems to conflicting with something and not working here
  versionCatalogs { create("llibs") { from(files("../gradle/libs.versions.toml")) } }
}
