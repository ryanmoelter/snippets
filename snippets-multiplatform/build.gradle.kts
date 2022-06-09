buildscript {
  repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
  }
  dependencies {
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.kotlin.get()}")
    classpath("com.android.tools.build:gradle:7.3.0-beta02")
  }
}

allprojects {
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}