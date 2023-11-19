plugins {
    with(catalogPlugins.plugins) {
        plugin(android.library)
        plugin(kotlin.android)
        plugin(kotlin.serialization)
        id(mersey.android.extension.id())
        id(mersey.kotlin.extension.id())
    }
    `maven-publish-plugin`
}

android {
    namespace = "com.merseyside.firestore"
    compileSdk = Application.compileSdk

    defaultConfig {
        minSdk = Application.minSdk
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
    common.mersey.kotlin.ext,
    androidLibs.firebase.firestore,
    androidLibs.coroutines,
    androidLibs.mersey.utils
)

dependencies {
    implementation(platform(androidLibs.firebase.bom))
    android.forEach { lib -> implementation(lib) }
}