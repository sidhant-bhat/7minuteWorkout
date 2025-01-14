plugins {
    id ("com.android.application") version "8.2.0-rc01"
    id ("org.jetbrains.kotlin.android") version "1.9.23"
    id("kotlin-kapt")
}

android {
    namespace = "eu.tutorials.a7_minutesworkoutapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "eu.tutorials.a7_minutesworkoutapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding =true
    }
    kapt {
        correctErrorTypes = true
    }

}

dependencies {
  implementation("androidx.room:room-common:2.6.1")
    /*  def room_version = "2.5.0"
       implementation ("androidx.room:room-ktx:$room_version")
       kapt ("androidx.room:room-complier:$room_version")  */

    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

//end

    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.8.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.0")
    implementation ("androidx.core:core-ktx:1.6.0")
    implementation ("androidx.appcompat:appcompat:1.3.1")
    implementation ("com.google.android.material:material:1.4.0")
    implementation( "androidx.constraintlayout:constraintlayout:2.1.0")
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    implementation( "com.google.android.material:material:1.9.0")
}
