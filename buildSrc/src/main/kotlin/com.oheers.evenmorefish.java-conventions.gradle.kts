plugins {
    id("java")
    id("maven-publish")
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.codemc.org/repository/maven-public/")
    maven("https://jitpack.io")
}

tasks {
    if (project.name.contains("addons")) {
        val addonName = defaultAddonName(project.name)
        jar {
            archiveFileName.set(addonName)
        }
        build {
            doLast {
                copy {

                    val sourceFolder = project.layout.buildDirectory.dir("libs/${addonName}").get()
                    val targetFolder = File(rootProject.project(":even-more-fish-plugin").projectDir, "src/main/resources/addons")
                    from(sourceFolder)
                    into(targetFolder)
                    logger.lifecycle("Copying $addonName from $sourceFolder to $targetFolder")
                }
            }
        }
    }
}

fun defaultAddonName(project: String): String {
    val jvmVersion = project.split("-")[4].uppercase()
    return "EMF-Addons-${jvmVersion}.addon"
}

