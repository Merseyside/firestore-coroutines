object LibraryVersions {

    object Application {
        const val packageName = "com.merseyside.firestore"
        const val applicationId = "com.merseyside.firestore"
    }

    object Android {
        const val compileSdk = 28
        const val targetSdk = 29
        const val minSdk = 17

        const val version = "1.0.1"
        const val versionCode = 101
    }

    object Common {
        const val coroutines = "1.4.2"
        const val serialization = "1.0.1"
    }

    const val kotlin = "1.3.72"

    object Plugins {
        const val android = "4.1.1"

        const val kotlin = LibraryVersions.kotlin
        const val serialization = LibraryVersions.kotlin
        const val maven = "2.1"
    }

    object Libs {
        object Android {
            const val appCompat = "1.2.0"
            const val annotation = "1.2.0-alpha01"
            const val material = "1.2.1"
            const val coroutines = "1.4.2"
            const val firebaseFirestore = "22.0.0"
            const val gson = "2.8.6"
            const val merseyLibs = "1.2.6"
        }
    }
}