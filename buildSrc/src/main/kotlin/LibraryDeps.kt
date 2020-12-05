object LibraryDeps {
    object Plugins {
        val androidApplication = PluginDesc(id = "com.android.application")
        val kotlinKapt = PluginDesc(id = "kotlin-kapt")
        val kotlinAndroid = PluginDesc(id = "kotlin-android")

        val androidLibrary = PluginDesc(
            id = "com.android.library",
            module = "com.android.tools.build:gradle:${LibraryVersions.Plugins.android}"
        )

        val kotlinSerialization = PluginDesc(
            id = "kotlinx-serialization",
            module = "org.jetbrains.kotlin:kotlin-serialization:${LibraryVersions.Plugins.serialization}"
        )

        val jitpack = PluginDesc(
            id = "com.github.dcendents.android-maven",
            module = "com.github.dcendents:android-maven-gradle-plugin:${LibraryVersions.Plugins.maven}"
        )
    }

    object Libs {
        object Android {
            const val appCompat = "androidx.appcompat:appcompat:${LibraryVersions.Libs.Android.appCompat}"
            const val material = "com.google.android.material:material:${LibraryVersions.Libs.Android.material}"
            const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibraryVersions.Common.coroutines}"
            const val annotation = "androidx.annotation:annotation:${LibraryVersions.Libs.Android.annotation}"
            const val firebaseFirestore ="com.google.firebase:firebase-firestore-ktx:${LibraryVersions.Libs.Android.firebaseFirestore}"
            const val utils = "com.github.Merseyside.mersey-android-library:utils:${LibraryVersions.Libs.Android.merseyLibs}"
        }
    }
}