plugins {
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.android.library)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.feature.movies"
    compileSdk = 34

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.dagger.main)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.paging.compose)
    implementation(libs.paging.common)
    implementation(libs.coil.core)
    implementation(libs.coil.compose)
    implementation(libs.compose.preview)
    ksp(libs.dagger.compiler)

    implementation(project(":core:network"))
    implementation(project(":core"))
}