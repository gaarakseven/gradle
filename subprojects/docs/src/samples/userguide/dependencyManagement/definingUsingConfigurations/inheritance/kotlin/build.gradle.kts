plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

// tag::configuration-definition[]
val smokeTest by configurations.creating {
    extendsFrom(configurations["testImplementation"])
}

dependencies {
    testImplementation("junit:junit:4.12")
    smokeTest("org.apache.httpcomponents:httpclient:4.5.5")
}
// end::configuration-definition[]

task<Copy>("copyLibs") {
    from(smokeTest)
    into("$buildDir/libs")
}
