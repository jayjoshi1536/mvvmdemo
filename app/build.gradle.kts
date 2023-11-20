plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.mvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mvvm"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(("androidx.core:core-ktx:1.9.0"))
    implementation(("androidx.appcompat:appcompat:1.6.1"))
    implementation(("com.google.android.material:material:1.10.0"))
    implementation(("androidx.constraintlayout:constraintlayout:2.1.4"))
    implementation (("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.20"))
    implementation(("com.android.support:multidex:1.0.3"))
    implementation(("androidx.legacy:legacy-support-v4:1.0.0"))
    implementation("androidx.annotation:annotation:1.7.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    // Material Components
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.coordinatorlayout:coordinatorlayout:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // RecycleView
    implementation("androidx.recyclerview:recyclerview")
    implementation("androidx.test:monitor:1.6.1")
    implementation("androidx.test.ext:junit-ktx:1.1.5")


    implementation ("androidx.fragment:fragment-ktx:1.6.2")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.6.2")

    // Retrofit - Gson
    implementation("com.google.code.gson:gson:2.10")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.3.0")
    implementation("com.squareup.retrofit2:converter-simplexml:2.1.0")
    implementation("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")

    // okHttpClient
    implementation(("com.squareup.okhttp3:okhttp"))
    implementation(("com.squareup.okhttp3:logging-interceptor"))
    implementation("com.squareup.okhttp3:okhttp-urlconnection:4.9.0")
    implementation((platform("com.squareup.okhttp3:okhttp-bom:4.9.0")))

    // ImageLoading
//    implementation("com.github.bumptech.glide:glide:4.15.1")
//    annotationProcessor("com.github.bump tech.glide:compiler:4.14.2")

    implementation("com.github.bumptech.glide:glide:4.15.1")
    kapt("com.github.bumptech.glide:compiler:4.15.1")

//    implementation("com.google.dagger:dagger:2.43.2")
//    annotationProcessor ("com.google.dagger:dagger-compiler:2.43.2")
//
//    implementation("com.google.dagger:hilt-android:2.43.2")
//    kapt("com.google.dagger:hilt-compiler:2.43.2")

    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-compiler:2.48.1")

    // For instrumentation tests
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.48.1")
    kaptAndroidTest("com.google.dagger:hilt-compiler:2.48.1")

    // For local unit tests
    testImplementation("com.google.dagger:hilt-android-testing:2.48.1")
    kaptTest("com.google.dagger:hilt-compiler:2.48.1")


    implementation("com.zsoltsafrany:needle:1.0.0")

    //work manager
    implementation ("androidx.work:work-runtime-ktx:2.8.1")

    //date
    implementation("me.moallemi.tools:kotlin-date-extensions:0.0.1")


    //For rememberLauncherForActivityResult()
    implementation("androidx.activity:activity-compose:1.8.1")

    //For PickVisualMedia contract
    implementation("androidx.activity:activity-ktx:1.8.1")


    implementation("com.google.android.material:material:1.12.0-alpha01")

    //Barcode
    implementation("com.google.android.gms:play-services-vision:20.1.3")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

kapt {
    correctErrorTypes = true
}