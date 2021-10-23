plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinSerialization)
    id(Plugins.mavenPublish)
}

group = Versions.Application.groupId
version = Versions.Application.version

android {
    compileSdkVersion(Versions.Application.compileSdk)

    defaultConfig {
        minSdkVersion(Versions.Application.minSdk)
        targetSdkVersion(Versions.Application.targetSdk)
        versionCode = Versions.Application.versionCode
        versionName = Versions.Application.version
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("release") {
            isMinifyEnabled = false
            consumerProguardFiles("proguard-rules.pro")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

val android = listOf(
    androidLibs.firebaseFirestore,
    androidLibs.coroutines,
    androidLibs.merseyLib.utils
)

dependencies {
    android.forEach { lib -> implementation(lib) }
}

afterEvaluate {
    publishing.publications {
        create<MavenPublication>("release") {
            groupId = group.toString()
            artifactId = project.name
            version = rootProject.version.toString()
            from(components["release"])
        }
    }

    repositories {
        mavenCentral()
    }
}