plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

group = "com.example"
version = "SNAPSHOT"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
}

gradlePlugin {
    plugins.register("greeting") {
        id = "com.example.greeting"
        implementationClass = "GreetingPlugin"
    }
}