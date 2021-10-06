plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

enum class Test {
    WORKS,
    DOESNT_WORK_1,
    DOESNT_WORK_2,
    DOESNT_WORK_3
}

val test = Test.WORKS
//val test = Test.DOESNT_WORK_1
//val test = Test.DOESNT_WORK_2
//val test = Test.DOESNT_WORK_3

dependencies {
    when (test) {
        Test.WORKS -> {
            implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
            implementation("com.example:greeting:SNAPSHOT")
        }
        Test.DOESNT_WORK_1 -> {
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
            implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
            implementation("com.squareup.sqldelight:gradle-plugin:1.5.1") {
//                or
                exclude(group = "org.jetbrains.kotlin")
//                or
//                isTransitive = false
            }
            implementation("com.example:greeting:SNAPSHOT")
        }
        Test.DOESNT_WORK_2 -> {
            /*EMPTY*/
        }
        Test.DOESNT_WORK_3 -> {
            implementation("com.squareup.sqldelight:gradle-plugin:1.5.1") {
                exclude(group = "org.jetbrains.kotlin")
//                or
//                isTransitive = false
//                or
//                exclude(group = "org.jetbrains.kotlin", module = "kotlin-gradle-plugin")
//                exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib-jdk8")
//                but not (need both stdlib and plugin)
//                exclude(group = "org.jetbrains.kotlin", module = "kotlin-gradle-plugin")
            }
        }
    }
}