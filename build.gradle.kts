import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking

buildscript {
    repositories {
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
                classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
                classpath("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
                classpath("com.squareup.sqldelight:gradle-plugin:1.5.1") {
//                    or
//                    exclude(group = "org.jetbrains.kotlin")
//                    or
                    isTransitive = false
                }
            }
            3 -> {
                classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
                classpath("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
            }
        }
    }
}

tasks.register("crashMe") {
    doLast {
        runBlocking {
            (0..5)
                .map { index -> async { index } }
                .awaitAll()
        }
    }
}