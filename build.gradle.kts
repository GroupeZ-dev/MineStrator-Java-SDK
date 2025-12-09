import java.util.Locale

plugins {
    `java-library`
    id("com.github.johnrengelman.shadow") version "8.1.1"
    `maven-publish`
}

rootProject.extra.properties["sha"]?.let { sha ->
    version = sha
}
group = "fr.maxlego08.minestrator"
version = "1.0"

extra.set("targetFolder", file("target/"))
extra.set("apiFolder", file("target-api/"))
extra.set("classifier", System.getProperty("archive.classifier"))
extra.set("sha", System.getProperty("github.sha"))

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }

    withJavadocJar()
    withSourcesJar()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.1")
}

tasks.withType<Jar> {
    manifest {
        attributes["Implementation-Title"] = "Sarah"
        attributes["Implementation-Version"] = project.version
    }
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveClassifier.set("")
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

publishing {

    var repository = System.getProperty("repository.name", "snapshots").replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

    repositories {
        maven {
            name = "groupez${repository}"
            url = uri("https://repo.groupez.dev/${repository.lowercase()}")
            credentials {
                username = findProperty("${name}Username") as String? ?: System.getenv("MAVEN_USERNAME")
                password = findProperty("${name}Password") as String? ?: System.getenv("MAVEN_PASSWORD")
            }
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }

    publications {
        register<MavenPublication>("groupez${repository}") {
            pom {
                groupId = project.group as String?
                artifactId = rootProject.name.lowercase()
                version = if (repository.lowercase() == "snapshots") {
                    System.getProperty("github.sha")
                } else {
                    project.version as String?
                }

                scm {
                    connection = "scm:git:git://github.com/GroupeZ-dev/${rootProject.name}.git"
                    developerConnection = "scm:git:ssh://github.com/GroupeZ-dev/${rootProject.name}.git"
                    url = "https://github.com/GroupeZ-dev/${rootProject.name}/"
                }
            }
            artifact(tasks.shadowJar)
            // artifact(tasks.javadocJar)
            // artifact(tasks.sourcesJar)
        }
    }
}

