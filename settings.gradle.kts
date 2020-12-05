include(":library")
enableFeaturePreview("GRADLE_METADATA")

val properties = startParameter.projectProperties
val libraryPublish: Boolean = properties.containsKey("libraryPublish")

include(":app", ":library")

rootProject.name = "mersey-android-library"