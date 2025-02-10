plugins {
    kotlin("jvm") version "1.9.20"
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "fr.neskuik"
version = "1.0"
description = "ClearLag made by Neskuik_ for SkyMC"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
    maven { url = uri("https://repo.aikar.co/content/groups/aikar/") }

    flatDir {
        dirs("libs")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    implementation("com.google.code.gson:gson:2.8.8")
    implementation("co.aikar:acf-paper:0.5.1-SNAPSHOT")

    implementation(files("libs/placeholderapi-2.11.6.jar"))
}

tasks {
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
        }
    }

    shadowJar {
        archiveFileName.set("ClearLag.jar")

        // Configure les relocations pour éviter les conflits de dépendances
        relocate("com.google.gson", "fr.neskuik.core.libs.gson")
        relocate("org.apache.http", "fr.neskuik.core.libs.http")

        manifest {
            attributes["Main-Class"] = "fr.neskuik.clearlag.ClearLag"
        }
    }

    // Configuration du jar normal
    jar {
        archiveFileName.set("ClearLag-without-dependencies.jar")
        manifest {
            attributes["Main-Class"] = "fr.neskuik.clearlag.ClearLag"
        }
    }

    // Make build depend on shadowJar
    build {
        dependsOn(shadowJar)
    }
}