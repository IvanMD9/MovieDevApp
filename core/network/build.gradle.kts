plugins {
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.android.library)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.core.network"
    compileSdk = 34

    defaultConfig {
        buildConfigField(
            "String",
            "MOVIES_API_KEY",
            "\"Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1N2MwZWJlNTI5MjgxMzVmMGZhNjI1MzI4NmUxZjlhNCIsIm5iZiI6MTcxOTIzNTgwMC4zMTcxMDEsInN1YiI6IjY0MDIzZDhhNjk5ZmI3MDA3ZDhmYzAzNiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.5xZ7KVmR5H-rB63dbTFytN9FLPNwjH2UBFiSdNrOD40\""
        )
        buildConfigField("String", "MOVIES_API_BASE_URL", "\"https://api.themoviedb.org/\"")
    }

    buildFeatures {
        buildConfig = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.retorfit.gson.converter)
    implementation(libs.dagger.main)
    ksp(libs.dagger.compiler)
}