plugins {
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.example.core"
    compileSdk = 34
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.paging.compose)
    implementation(libs.paging.common)
}