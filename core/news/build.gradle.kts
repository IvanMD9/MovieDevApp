plugins {
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.example.core.news"
    compileSdk = 34

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
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.coil.core)
    implementation(libs.coil.compose)
    implementation(libs.androidx.material3)
    implementation(libs.compose.preview)
    implementation(libs.paging.compose)
    implementation(libs.paging.common)

    implementation(project(":core"))
    implementation(project(":core:ui"))
}