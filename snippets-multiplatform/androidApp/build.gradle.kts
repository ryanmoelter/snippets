plugins {
  id("com.android.application")
  kotlin("android")
  alias(libs.plugins.ksp)
}

android {
  compileSdk = 32
  defaultConfig {
    applicationId = "com.ryanmoelter.snippets"
    minSdk = 26
    targetSdk = 32
    versionCode = 1
    versionName = "1.0"
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
    }
  }

  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.compose.get()
  }

  buildFeatures {
    compose = true
  }

  sourceSets {
    getByName("debug") {
      kotlin.srcDir("build/generated/ksp/debug/kotlin")
    }
    getByName("release") {
      kotlin.srcDir("build/generated/ksp/release/kotlin")
    }
  }
}

tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinCompile<*>>().all {
  kotlinOptions.freeCompilerArgs = listOf(
    "-Xopt-in=kotlin.RequiresOptIn"
  )
}

tasks.withType<Test> {
  useJUnitPlatform()
}

dependencies {
  implementation(project(":shared"))

  implementation(libs.magellanx.compose)
  testImplementation(libs.magellanx.test)

  implementation(libs.kotlin.inject.runtime)
  ksp(libs.kotlin.inject.compiler.ksp)

  implementation(libs.bundles.compose)
  debugImplementation(libs.bundles.compose.debug)
  androidTestImplementation(libs.bundles.compose.android.test)

  implementation(libs.bundles.android)
  testImplementation(libs.bundles.test)
}