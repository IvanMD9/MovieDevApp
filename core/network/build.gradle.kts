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
            "NEWS_API_KEY",
            "\"0807aa6f18214b018149e7c552e74394\""
        )
        buildConfigField("String", "NEWS_API_BASE_URL", "\"https://newsapi.org/\"")
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
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.retorfit.gson.converter)
    implementation(libs.dagger.main)
    ksp(libs.dagger.compiler)
}