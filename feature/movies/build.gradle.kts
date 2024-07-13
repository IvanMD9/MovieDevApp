plugins {
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.android.library)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.feature.movies"
    compileSdk = 34

    defaultConfig {
        minSdk = 29

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.paging.compose)
    implementation(libs.paging.common)
    implementation(libs.coil.core)
    implementation(libs.coil.compose)
    implementation(libs.compose.preview)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.dagger.main)
    implementation(libs.androidx.material3)
    ksp(libs.dagger.compiler)

    implementation(project(":core:network"))
    implementation(project(":core"))
}