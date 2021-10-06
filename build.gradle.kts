
buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    dependencies {
//        val test = 0 //WORKS
        val test = 1 //DOESNT_WORK1
//        val test = 2 //DOESNT_WORK2
//        val test = 3 //DOESNT_WORK3
        when (test) {
            0 -> {
                classpath("com.squareup.sqldelight:gradle-plugin:1.5.1") {
                    exclude(group = "org.jetbrains.kotlin")
//                    or
//                    isTransitive = false
//                    or
//                    exclude(group = "org.jetbrains.kotlin", module = "kotlin-gradle-plugin")
//                    exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib-jdk8")
//                    but not (need both stdlib and plugin)
//                    exclude(group = "org.jetbrains.kotlin", module = "kotlin-gradle-plugin")
                }
            }
            1 -> {
                /*EMPTY*/
            }
            2 -> {
                classpath("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
                classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
                classpath("com.squareup.sqldelight:gradle-plugin:1.5.1")
                classpath("com.example:greeting:SNAPSHOT")
            }
            3 -> {
                classpath("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
                classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
                classpath("com.squareup.sqldelight:gradle-plugin:1.5.1")
                classpath("com.example:greeting:SNAPSHOT")
            }
        }
    }
}

allprojects {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

apply(plugin = "com.example.greeting")