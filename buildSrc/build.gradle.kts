plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

enum class Test {
    WORKS,
    DOESNT_WORK_1,
    DOESNT_WORK_2,
    DOESNT_WORK_3
}

//val test = Test.WORKS
val test = Test.DOESNT_WORK_1
//val test = Test.DOESNT_WORK_2
//val test = Test.DOESNT_WORK_3

dependencies {
    when (test) {
        Test.WORKS -> {
            implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
        }
        Test.DOESNT_WORK_1 -> {
            implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
            implementation("com.squareup.sqldelight:gradle-plugin:1.5.1") {
//                or
//                exclude(group = "org.jetbrains.kotlin")
//                or
                isTransitive = false
            }
        }
        Test.DOESNT_WORK_2 -> {
            /*EMPTY*/
        }
        Test.DOESNT_WORK_3 -> {
            implementation("com.squareup.sqldelight:gradle-plugin:1.5.1") {
//                or
//                exclude(group = "org.jetbrains.kotlin")
//                or
                isTransitive = false
            }
        }
    }
}