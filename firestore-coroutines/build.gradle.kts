plugins {
    plugin(FirestoreLibraryDeps.Plugins.androidLibrary)
    plugin(FirestoreLibraryDeps.Plugins.kotlinAndroid)
    plugin(FirestoreLibraryDeps.Plugins.kotlinSerialization)
    plugin(FirestoreLibraryDeps.Plugins.mavenPublish)
}

group = FirestoreLibraryVersions.Application.groupId
version = FirestoreLibraryVersions.Application.version

android {
    compileSdkVersion(FirestoreLibraryVersions.Application.compileSdk)

    defaultConfig {
        minSdkVersion(FirestoreLibraryVersions.Application.minSdk)
        targetSdkVersion(FirestoreLibraryVersions.Application.targetSdk)
        versionCode = FirestoreLibraryVersions.Application.versionCode
        versionName = FirestoreLibraryVersions.Application.version

        multiDexEnabled = true
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

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

val androidLibs = listOf(
    FirestoreLibraryDeps.Libs.firebaseFirestore,
    FirestoreLibraryDeps.Libs.coroutines,
    FirestoreLibraryDeps.Libs.utils
)

dependencies {
    compileOnly("javax.annotation:jsr250-api:1.0")

    androidLibs.forEach { lib -> implementation(lib) }
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