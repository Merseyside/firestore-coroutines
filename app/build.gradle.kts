plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
}

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
    androidLibs.appCompat,
    androidLibs.material
)

dependencies {
    android.forEach { lib -> implementation(lib) }
}