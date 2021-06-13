import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    plugin(FirestoreLibraryDeps.Plugins.androidApplication)
    plugin(FirestoreLibraryDeps.Plugins.kotlinAndroid)
}

android {
    compileSdkVersion(FirestoreLibraryVersions.Application.compileSdk)

    defaultConfig {
        minSdkVersion(FirestoreLibraryVersions.Application.minSdk)
        targetSdkVersion(FirestoreLibraryVersions.Application.targetSdk)
        versionCode = FirestoreLibraryVersions.Application.versionCode
        versionName = FirestoreLibraryVersions.Application.version
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

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/license.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/notice.txt")
        exclude("META-INF/ASL2.0")
        exclude("META-INF/*.kotlin_module")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

val androidLibs = listOf(
    FirestoreLibraryDeps.Libs.appCompat,
    FirestoreLibraryDeps.Libs.material
)

dependencies {
    androidLibs.forEach { lib -> implementation(lib) }

    compileOnly("javax.annotation:jsr250-api:1.0")
}