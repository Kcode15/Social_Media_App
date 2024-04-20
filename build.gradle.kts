import java.net.URI

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
}
buildscript{
    repositories{
        google()
        mavenCentral()
    }
    dependencies{
        classpath("com.android.tools.build:gradle:8.1.4")
        classpath("com.google.gms:google-services:4.3.2")
    }
}
allprojects {
    repositories {
        maven { url= URI("https://jitpack.io") }
    }
}