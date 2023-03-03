plugins {
    kotlin("jvm") version "1.8.10"
    id("io.ktor.plugin") version "2.2.4"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.10"
}

group = "cc.suffro"
version = "0.0.1"

application {
    mainClass.set("cc.suffro.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

object Version {
    const val EXPOSED = "0.41.1"
    const val H2 = "2.1.214"
    const val JUNIT = "5.9.1"
    const val KOTLIN = "1.8.10"
    const val KTOR = "2.2.4"
    const val LOGBACK = "1.4.5"
    const val LOGGING = "3.0.2"
    const val MOCKK = "1.13.3"
    const val SLF4J = "2.0.6"
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:${Version.KTOR}")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:${Version.KTOR}")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:${Version.KTOR}")
    testImplementation("io.ktor:ktor-server-tests-jvm:${Version.KTOR}")
    implementation("io.ktor:ktor-serialization-jackson-jvm:${Version.KTOR}")
    implementation("io.ktor:ktor-server-netty-jvm:${Version.KTOR}")

    implementation("org.jetbrains.exposed:exposed-core:${Version.EXPOSED}")
    implementation("org.jetbrains.exposed:exposed-jdbc:${Version.EXPOSED}")

    implementation("com.h2database:h2:${Version.H2}")

    implementation("io.github.microutils:kotlin-logging-jvm:${Version.LOGGING}")
    runtimeOnly("ch.qos.logback:logback-classic:${Version.LOGBACK}")
    implementation("org.slf4j:slf4j-simple:${Version.SLF4J}")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:${Version.KOTLIN}")

    testImplementation("io.mockk:mockk:${Version.MOCKK}")

    testImplementation("org.junit.jupiter:junit-jupiter-api:${Version.JUNIT}")
    testImplementation("org.junit.jupiter:junit-jupiter-params:${Version.JUNIT}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Version.JUNIT}")
}
