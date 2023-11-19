plugins {
    `kotlin-dsl`
}

dependencies {
    with(catalogGradle) {
        implementation(android.gradle.stable)
        implementation(kotlin.gradle)
        implementation(kotlin.serialization)
        implementation(mersey.gradlePlugins)
        implementation(crashlytics)
        implementation(maven.publish.plugin)
    }
}

