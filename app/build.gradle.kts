plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    //id ("dagger.hilt.android.plugin")
    //id ("kotlinx-serialization")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.splitwise"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.splitwise"
        minSdk = 29
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("androidx.compose.material:material:1.5.4")



        val nav_version = "2.7.5"

        // Java language implementation
        implementation("androidx.navigation:navigation-fragment:$nav_version")
        implementation("androidx.navigation:navigation-ui:$nav_version")

        // Kotlin
        implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
        implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

        // Feature module Support
        implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

        // Testing Navigation
        androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")

        // Jetpack Compose Integration
        implementation("androidx.navigation:navigation-compose:$nav_version")




// Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.4.0-beta02")

    // Room components
    implementation ("androidx.room:room-runtime:2.3.0")
    implementation ("androidx.room:room-ktx:2.3.0")
    implementation ("androidx.room:room-paging:2.4.1")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

    // Paging 3.0
    implementation ("androidx.paging:paging-compose:1.0.0-alpha14")

    // KotlinX Serialization
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")

    // DataStore Preferences
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // Dagger - Hilt
    implementation ("com.google.dagger:hilt-android:2.38.1")
    //ksp ("com.google.dagger:hilt-android-compiler:2.38.1")
    //ksp ("androidx.hilt:hilt-compiler:1.1.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0")

    // Coil
    implementation("io.coil-kt:coil-compose:1.3.2")

    // Horizontal Pager and Indicators - Accompanist
  //  implementation ("com.google.accompanist:accompanist-pager:$accompanist_version")
  //  implementation ("com.google.accompanist:accompanist-pager-indicators:$accompanist_version")

    // Swipe to Refresh - Accompanist
   // implementation ("com.google.accompanist:accompanist-swiperefresh:$accompanist_version")

    // System UI Controller - Accompanist
   // implementation ("com.google.accompanist:accompanist-systemuicontroller:$accompanist_version")

    // Palette API
    implementation ("androidx.palette:palette-ktx:1.0.0")

    // Testing


}