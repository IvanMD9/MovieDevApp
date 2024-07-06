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
    implementation(project(":core:network"))
    implementation(libs.dagger.main)
    ksp(libs.dagger.compiler)
}