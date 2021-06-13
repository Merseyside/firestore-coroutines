object FirestoreLibraryVersions {

    object Application {
        const val groupId = "com.github.Merseyside"
        const val artifactId = "firestore-coroutines"

        const val version = "1.0.2"
        const val versionCode = 102

        const val compileSdk = 30
        const val targetSdk = 30
        const val minSdk = 21
    }

    object Common {
        const val coroutines = "1.5.0"
        const val serialization = "1.2.1"
    }

    const val kotlin = "1.5.0"

    object Plugins {
        const val android = "4.2.1"

        const val kotlin = FirestoreLibraryVersions.kotlin
        const val serialization = FirestoreLibraryVersions.kotlin
    }

    object Libs {
        object Android {
            const val appCompat = "1.2.0"
            const val annotation = "1.2.0-alpha01"
            const val material = "1.2.1"
            const val coroutines = "1.5.0"
            const val firebaseFirestore = "22.0.0"
            const val merseyLibs = "1.3.6"
        }
    }
}