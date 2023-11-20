plugins {
    alias(libs.plugins.android.application)
//    alias(libs.plugins.org.jetbrains.kotlin.android)
    id("org.jetbrains.kotlin.android")
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.sqlDelight)
}

android {
    namespace = "com.faroukabichou.kotlincleanarch"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.faroukabichou.kotlincleanarch"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packagingOptions {
        exclude("META-INF/INDEX.LIST")
        exclude("META-INF/versions/9/previous-compilation-data.bin")
    }
}

dependencies {

    // Core
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activityCompose)
    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.viewmodelCompose)
    implementation(libs.androidx.lifecycle.runtimeCompose)

    // Navigation
    implementation(libs.androidx.navigation.compose)

    // Compose
    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.compose.material3)
    implementation(libs.compose.uitooling)

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)

    // Compose Util
    implementation(libs.androidx.ui.util)

    //Coil
    implementation(libs.coil.compose)
    implementation(libs.coil.svg)

    // ConstraintLayout
    implementation(libs.androidx.constraintLayout)

    // EXIF Interface
    implementation(libs.androidx.exifinterface)

    // koin
    implementation(libs.koin.core)
    implementation(libs.koin.android)

    // KotlinX
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.core)

    // Ktor
    implementation(libs.ktor.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.content.negotiation)
    implementation(libs.ktor.serialization.json)
    implementation(libs.ktor.logging)
    implementation(libs.ktor.client.auth)
    implementation(libs.logback.classic)

    //SQL Delight
    implementation(libs.sqlDelight.driver.android)
}

sqldelight {
    databases {
        create("MyDatabase") { //Should be a Meaningfully name

        }
    }
}