plugins {
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.example.core"
    compileSdk = 34
}