plugins {
    java
}

version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("commons-io:commons-io:2.6")
}

// tag::link-task-properties[]
val archivesDirPath by extra { "$buildDir/archives" }

task<Zip>("packageClasses") {
    appendix = "classes"
    destinationDir = file(archivesDirPath)

    from(tasks["compileJava"])
}
// end::link-task-properties[]

// tag::nested-specs[]
task<Copy>("nestedSpecs") {
    into("$buildDir/explodedWar")
    exclude("**/*staging*")
    from("src/dist") {
        include("**/*.html", "**/*.png", "**/*.jpg")
    }
    from(sourceSets["main"].output) {
        into("WEB-INF/classes")
    }
    into("WEB-INF/lib") {
        from(configurations.runtimeClasspath)
    }
}
// end::nested-specs[]
