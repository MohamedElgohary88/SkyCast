import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.chocolate.skycast"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev") {
        url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    }

}

kotlin {
    jvm {
        jvmToolchain(11)
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation("io.ktor:ktor-client-logging:2.3.2")
            }
        }
        val commonMain by getting {
            dependencies {
                val ktorVersion = "2.3.2"
                val voyagerVersion = "1.0.0-rc05"

                implementation("io.ktor:ktor-client-java:$ktorVersion")
                implementation("io.insert-koin:koin-core:3.4.2")
                implementation("io.ktor:ktor-client-json:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-gson:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                implementation("com.google.code.gson:gson:2.10.1")
                implementation("org.jetbrains.compose.material3:material3-desktop:1.0.0")

                // Navigator
                implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")

                // Kodein integration
                implementation("cafe.adriel.voyager:voyager-kodein:$voyagerVersion")


            }
        }

        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "SkyCast"
            packageVersion = "1.0.0"
        }
    }
}
