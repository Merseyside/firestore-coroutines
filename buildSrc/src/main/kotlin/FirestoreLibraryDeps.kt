object FirestoreLibraryDeps {
    object Plugins {
        val androidApplication = GradlePlugin(id = "com.android.application")
        val kotlinKapt = GradlePlugin(id = "kotlin-kapt")
        val kotlinAndroid = GradlePlugin(id = "kotlin-android")
        val mavenPublish = GradlePlugin(id = "maven-publish")
        val androidLibrary = GradlePlugin(id = "com.android.library")

        val kotlinSerialization = GradlePlugin(
            id = "kotlinx-serialization",
            module = "org.jetbrains.kotlin:kotlin-serialization:${FirestoreLibraryVersions.Plugins.serialization}"
        )
    }

    object Libs {
        const val appCompat =
            "androidx.appcompat:appcompat:${FirestoreLibraryVersions.Libs.Android.appCompat}"
        const val material =
            "com.google.android.material:material:${FirestoreLibraryVersions.Libs.Android.material}"
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${FirestoreLibraryVersions.Common.coroutines}"
        const val annotation =
            "androidx.annotation:annotation:${FirestoreLibraryVersions.Libs.Android.annotation}"
        const val firebaseFirestore =
            "com.google.firebase:firebase-firestore-ktx:${FirestoreLibraryVersions.Libs.Android.firebaseFirestore}"
        const val utils =
            "com.github.Merseyside.mersey-android-library:utils:${FirestoreLibraryVersions.Libs.Android.merseyLibs}"
    }
}